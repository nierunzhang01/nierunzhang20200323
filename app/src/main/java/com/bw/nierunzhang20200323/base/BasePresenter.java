package com.bw.nierunzhang20200323.base;

import android.os.Handler;
import android.os.Message;

import com.bw.nierunzhang20200323.bean.Result;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.23<p>
 * <p>更改时间：2020.3.23<p>
 */
public abstract class BasePresenter {
    private DataCall dataCall;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.obj==null){
                dataCall.feil();
            }else {
               Result result= (Result) msg.obj;
               dataCall.sercce(result);
            }
        }
    };
    public void request(final Object...args){
        new Thread(new Runnable(){
            @Override
            public void run() {
                Result result =getModel(args);
                final Message message = Message.obtain();
                message.obj=result;
        handler.sendMessage(message);
            }
        }).start();
    }

    protected abstract Result getModel(Object[] args);
}
