package com.tgjs.dql.mymvpdemo.base;

import android.content.Context;

/**
 * Created by dql on 2018/8/7.
 */

public  interface BaseView {
	public void showLoading();

	public void hideLoading();

	public void showErrorMsg(String errorMsg);
	Context getContext();
}
