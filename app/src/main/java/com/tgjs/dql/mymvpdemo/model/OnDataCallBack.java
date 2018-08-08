package com.tgjs.dql.mymvpdemo.model;

/**
 * Created by 王松 on 2016/10/8.
 */

public interface OnDataCallBack {
    public void onSuccess(String response);

    public void onFailed(String errorMsg);
}
