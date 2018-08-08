package com.tgjs.dql.mymvpdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dql on 2018/8/7.
 */

public abstract class BaseActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {
	public T presenter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getContentView());
		presenter = initPresenter();
		initView();
	}

	@Override
	protected void onResume() {
		super.onResume();
		presenter.attach((V)this);
	}

	@Override
	protected void onDestroy() {
		presenter.dettach();
		super.onDestroy();
	}

	// 实例化presenter
	public abstract T initPresenter();
	public abstract int getContentView();
	public abstract void initView();
}
