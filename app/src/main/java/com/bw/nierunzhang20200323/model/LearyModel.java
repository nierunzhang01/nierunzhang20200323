package com.bw.nierunzhang20200323.model;

import com.bw.nierunzhang20200323.bean.ShopBean;
import com.bw.nierunzhang20200323.bean.Result;
import com.bw.nierunzhang20200323.util.NetUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.23<p>
 * <p>更改时间：2020.3.23<p>
 */
public class LearyModel {
    public static Result<ShopBean> news(int page){
        final String json = NetUtils.getInstance().doGet("http://blog.zhaoliang5156.cn/api/shop/shop"+page+".json");
        if (json==null){
            return null;
        }
        final Gson gson = new Gson();
        final Type type = new TypeToken<Result<ShopBean>>() {}.getType();
        Result<ShopBean> data = gson.fromJson(json, type);
        return data;
    }
}
