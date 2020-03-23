package com.bw.nierunzhang20200323.base;

import com.bw.nierunzhang20200323.bean.Result;

/**
 * <p>文件描述：<p>
 * <p>作者：聂润璋<p>
 * <p>创建时间：2020.3.23<p>
 * <p>更改时间：2020.3.23<p>
 */
public interface DataCall<T> {
    void sercce(Result<T> result);
    void feil();
}
