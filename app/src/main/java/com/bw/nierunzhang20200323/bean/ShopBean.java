package com.bw.nierunzhang20200323.bean;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.23<p>
 * <p>更改时间：2020.3.23<p>
 */
public class ShopBean {
    //a)根据服务器响应的json封装ShopBean类
    public String currency_price;
    public String goods_name;
    public String goods_thumb;



    public String getGoods_thumb() {
        return goods_thumb;
    }

    public void setGoods_thumb(String goods_thumb) {
        this.goods_thumb = goods_thumb;
    }
}
