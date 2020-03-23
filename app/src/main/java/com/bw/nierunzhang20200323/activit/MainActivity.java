package com.bw.nierunzhang20200323.activit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.bw.nierunzhang20200323.R;
import com.bw.nierunzhang20200323.adapter.MyAdapter;
import com.bw.nierunzhang20200323.base.BaseActivity;
import com.bw.nierunzhang20200323.base.DataCall;
import com.bw.nierunzhang20200323.bean.ShopBean;
import com.bw.nierunzhang20200323.bean.Result;
import com.bw.nierunzhang20200323.presenter.LeayPresenter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

public class MainActivity extends BaseActivity implements DataCall<ShopBean> {
PullToRefreshListView pullToRefreshListView;
LeayPresenter presenter;
MyAdapter myAdapter;
    SharedPreferences sharedPreferences;
int page=1;


    @Override
    protected void initView(Bundle savedInstanceState) {


        presenter=new LeayPresenter(this);
        pullToRefreshListView=findViewById(R.id.pulllll);
        myAdapter=new MyAdapter();
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView.setAdapter(myAdapter);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page=1;
                presenter.request(page);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
            page++;
            presenter.request(page);
            }
        });
        presenter.request(page);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void sercce(Result<ShopBean> result) {
        pullToRefreshListView.onRefreshComplete();
        if (page==1){
            myAdapter.clear();
        }
        myAdapter.addAll(result.data);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void feil() {
        pullToRefreshListView.onRefreshComplete();
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }
}
