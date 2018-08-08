package com.tgjs.dql.mymvpdemo.presenter;

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
	private BaseDtataModel iBaseData;
	private Gson mGson;
	public IndexPresenter() {
		iBaseData = new BaseModel();
		mGson = new Gson();
	}

	public void loadData() {
		indexView.showLoading();
		TreeMap<String,String> paramsTreeMap = new TreeMap<>();
		iBaseData.postDataString(Constant.LISTURL,REQUEST_WHAT_INDEX,"index",paramsTreeMap,false, new OnDataCallBack() {
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
