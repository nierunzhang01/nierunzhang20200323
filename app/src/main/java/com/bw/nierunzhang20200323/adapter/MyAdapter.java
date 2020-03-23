package com.bw.nierunzhang20200323.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.nierunzhang20200323.R;
import com.bw.nierunzhang20200323.bean.ShopBean;
import com.bw.nierunzhang20200323.util.NetUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.23<p>
 * <p>更改时间：2020.3.23<p>
 */
public class MyAdapter extends BaseAdapter {
    private List<ShopBean> list=new ArrayList<>();

    @Override
    public int getCount() {
        return list.size();
    }
public void addAll(List<ShopBean> data){
        list.addAll(data);
}
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_top, parent, false);
            viewHolder=new ViewHolder();
            viewHolder.imageView=convertView.findViewById(R.id.img);
            viewHolder.name=convertView.findViewById(R.id.name);
            viewHolder.infooo=convertView.findViewById(R.id.infffff);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        final ShopBean learyBean = list.get(position);
        viewHolder.name.setText(learyBean.goods_name);
        viewHolder.infooo.setText(learyBean.currency_price);
    viewHolder.imageView.setImageBitmap(NetUtils.getInstance().doGetPhoto(learyBean.goods_thumb));


        viewHolder.imageView.setImageResource(R.mipmap.huawei);
        return convertView;
    }

    public void clear(){
        list.clear();
    }
    class ViewHolder{
        ImageView imageView;
        TextView name,infooo;
    }
}
