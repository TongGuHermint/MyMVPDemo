package com.tgjs.dql.mymvpdemo.base;

import com.tgjs.dql.mymvpdemo.model.OnDataCallBack;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by dql on 2018/8/8.
 */

public  interface BaseDtataModel {
	public void postDataString(final String url, final int what, String tag, final Map<String,String> paramsMap, boolean isShowProgress, OnDataCallBack onDataCallBack);
	public void getDataString(String url, final int what, boolean isShowProgress,OnDataCallBack onDataCallBack);
	public void downLoadFile(String url, final int what, String dir, String fileName, boolean isShowProgress,OnDataCallBack onDataCallBack);
	public void postDataStringWithFile(final String url, final int what, String tag, final Map<String,String> paramsMap, boolean isShowProgress, List<File> fileList,OnDataCallBack onDataCallBack);
}
