package com.tgjs.dql.mymvpdemo.activity;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.tgjs.dql.mymvpdemo.R;
import com.tgjs.dql.mymvpdemo.adapter.MyAdapter;
import com.tgjs.dql.mymvpdemo.base.BaseActivity;
import com.tgjs.dql.mymvpdemo.entity.IndexEntity;
import com.tgjs.dql.mymvpdemo.presenter.IndexPresenter;
import com.tgjs.dql.mymvpdemo.view.IndexView;

public class MainActivity extends BaseActivity<IndexView,IndexPresenter> implements IndexView {
	private RecyclerView lv;
	private ProgressBar pb;
	private MyAdapter adapter;
	@Override
	public IndexPresenter initPresenter() {
		return new IndexPresenter();
	}

	@Override
	public int getContentView() {
		return R.layout.activity_main;
	}

	@Override
	public void initView() {
		lv = (RecyclerView) findViewById(R.id.lv);
		pb = ((ProgressBar) findViewById(R.id.pb));
		presenter.loadData();
	}

	@Override
	public void showLoading() {
		pb.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideLoading() {
		pb.setVisibility(View.GONE);
	}

	@Override
	public void showErrorMsg(String errorMsg) {

	}

	@Override
	public Context getContext() {
		return this;
	}


	@Override
	public void initData(IndexEntity indexEntity) {
		lv.setLayoutManager(new LinearLayoutManager(this));
		adapter = new MyAdapter(null);
		lv.setAdapter(adapter);
		adapter.addData(indexEntity.getData());
	}
}
