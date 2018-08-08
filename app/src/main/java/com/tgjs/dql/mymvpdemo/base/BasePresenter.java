package com.tgjs.dql.mymvpdemo.base;

/**
 * Created by dql on 2018/8/7.
 */

public abstract class BasePresenter<T> {
	public T mView;

	public void attach(T mView) {
		this.mView = mView;
	}

	public void dettach() {
		mView = null;
	}

}
