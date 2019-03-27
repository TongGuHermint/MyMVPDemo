package com.tgjs.dql.mymvpdemo.presenter;

import android.app.ProgressDialog;

import com.google.gson.Gson;
import com.tgjs.dql.mymvpdemo.base.BaseDtataModel;
import com.tgjs.dql.mymvpdemo.base.BaseModel;
import com.tgjs.dql.mymvpdemo.constants.Constant;
import com.tgjs.dql.mymvpdemo.entity.IndexEntity;
import com.tgjs.dql.mymvpdemo.model.OnDataCallBack;
import com.tgjs.dql.mymvpdemo.view.IndexView;
import com.tgjs.dql.mymvpdemo.base.BasePresenter;

import java.util.TreeMap;

import static com.tgjs.dql.mymvpdemo.constants.RequestWhatI.REQUEST_WHAT_INDEX;

/**
 * Created by dql on 2018/8/7.
 */

public class IndexPresenter extends BasePresenter<IndexView> {
	private IndexView indexView;
	private BaseDtataModel baseDtataModel;
	private Gson mGson;
	public IndexPresenter(IndexView view) {
		this.indexView = view;
		baseDtataModel = new BaseModel();
		mGson = new Gson();
	}

	public void loadData() {
		indexView.showLoading();
		baseDtataModel.getDataString(Constant.LISTURL,REQUEST_WHAT_INDEX,false, new OnDataCallBack() {
			@Override
			public void onSuccess(String response) {
				IndexEntity indexEntity = mGson.fromJson(response,IndexEntity.class);
				indexView.initData(indexEntity);
				indexView.hideLoading();
			}

			@Override
			public void onFailed(String errorMsg) {
				indexView.showErrorMsg(errorMsg);
				indexView.hideLoading();
			}
		});
	}
}
