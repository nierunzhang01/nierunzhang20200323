package com.bw.nierunzhang20200323.presenter;

import com.bw.nierunzhang20200323.base.BasePresenter;
import com.bw.nierunzhang20200323.base.DataCall;
import com.bw.nierunzhang20200323.bean.Result;
import com.bw.nierunzhang20200323.model.LearyModel;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.23<p>
 * <p>更改时间：2020.3.23<p>
 */
public class LeayPresenter extends BasePresenter {
    public LeayPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Result getModel(Object[] args) {
        return LearyModel.news((int)args[0]);
    }
}
