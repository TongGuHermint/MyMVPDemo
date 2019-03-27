package com.tgjs.dql.mymvpdemo.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.Message;

import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tgjs.dql.mymvpdemo.constants.ConstValues;
import com.tgjs.dql.mymvpdemo.model.OnDataCallBack;
import com.tgjs.dql.mymvpdemo.utils.JsonUtil;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by dql on 2018/8/8.
 */

public class BaseModel implements BaseDtataModel{
	private ProgressDialog progressDialog;
	private Context context;
	@Override
	public void postDataString(final String url, final int what, String tag, final Map<String,String> paramsMap, boolean isShowProgress, final OnDataCallBack onDataCallBack){
		if (paramsMap!=null){
//			paramsMap.put("token",SPUtils.getInstance().getString(ConstValues.TOKEN));
		}
		if (isShowProgress){
			progressDialog = progressDialog.show(context,"","加载中！");
		}
		OkGo.<String>post(url)
//				.headers("token", SPUtils.getInstance().getString(ConstValues.TOKEN))
				.params(paramsMap,true)
				.tag(tag)
				.execute(new StringCallback() {
					@Override
					public void onSuccess(Response<String> response) {
						progressDialog.dismiss();
						//判断返回数据是否为json，如果不是先把url和传参和token写入本地文件，方便调试
						if (JsonUtil.isJsonValid(response.body().toString().trim())){
							onDataCallBack.onSuccess(response.body().toString().trim());
						}else {
							sendReloginBroadCast();
							writeErrorLog(Environment.getExternalStorageDirectory().getPath()+ConstValues.FILE_ROOT_DIRECTORY+"/log.txt"
									,url,paramsMap,SPUtils.getInstance().getString(ConstValues.TOKEN),response.body());
						}
					}

					@Override
					public void onError(Response<String> response) {
						progressDialog.dismiss();
						writeErrorLog(Environment.getExternalStorageDirectory().getPath()+ConstValues.FILE_ROOT_DIRECTORY+"/log.txt"
								,url,paramsMap,SPUtils.getInstance().getString(ConstValues.TOKEN),response.body());
						onDataCallBack.onFailed(response.body().toString().trim());
					}
				});
	}

	@Override
	public void getDataString(String url, final int what, boolean isShowProgress, final OnDataCallBack onDataCallBack) {
		if (isShowProgress){
			progressDialog = progressDialog.show(context,"","加载中！");
		}
		OkGo.<String>get(url).execute(new StringCallback() {
			@Override
			public void onSuccess(Response<String> response) {
//				progressDialog.dismiss();
				onDataCallBack.onSuccess(response.body().toString().trim());
			}

			@Override
			public void onError(Response<String> response) {
//				progressDialog.dismiss();
				onDataCallBack.onFailed(response.body().toString().trim());
			}
		});
	}

	@Override
	public void downLoadFile(String url, final int what, String dir, String fileName, boolean isShowProgress, final OnDataCallBack onDataCallBack) {
		if (isShowProgress){
			progressDialog = progressDialog.show(context,"","加载中！");
		}
		dir = Environment.getExternalStorageDirectory().getPath()+dir;
		File file = new File(dir);
		if (!file.exists()){
			file.mkdirs();
		}
		OkGo.<File>get(url).execute(new FileCallback(dir, fileName) {
			@Override
			public void onSuccess(Response<File> response) {
				progressDialog.dismiss();
				onDataCallBack.onSuccess(response.body().toString().trim());
			}

			@Override
			public void onError(Response<File> response) {
				progressDialog.dismiss();
				onDataCallBack.onFailed(response.body().toString().trim());
			}
		});
	}

	@Override
	public void postDataStringWithFile(final String url, final int what, String tag, final Map<String, String> paramsMap, boolean isShowProgress, List<File> fileList, final OnDataCallBack onDataCallBack) {
		if (paramsMap!=null){
			paramsMap.put("token", SPUtils.getInstance().getString(ConstValues.TOKEN));
		}
		if (isShowProgress){
			progressDialog = progressDialog.show(context,"","加载中！");
		}
		OkGo.<String>post(url)
				.headers("token", SPUtils.getInstance().getString(ConstValues.TOKEN))
				.params(paramsMap,true)
				.addFileParams("files",fileList)
				.tag(tag)
				.execute(new StringCallback() {
					@Override
					public void onSuccess(Response<String> response) {
						progressDialog.dismiss();
						//判断返回数据是否为json，如果不是先把url和传参和token写入本地文件，方便调试
						if (JsonUtil.isJsonValid(response.body().toString().trim())){
							onDataCallBack.onSuccess(response.body().toString().trim());
						}else {
							sendReloginBroadCast();
							writeErrorLog(Environment.getExternalStorageDirectory().getPath()+ConstValues.FILE_ROOT_DIRECTORY+"/log.txt"
									,url,paramsMap,SPUtils.getInstance().getString(ConstValues.TOKEN),response.body());
						}
					}

					@Override
					public void onError(Response<String> response) {
						writeErrorLog(Environment.getExternalStorageDirectory().getPath()+ConstValues.FILE_ROOT_DIRECTORY+"/log.txt"
								,url,paramsMap,SPUtils.getInstance().getString(ConstValues.TOKEN),response.body());
						progressDialog.dismiss();
						onDataCallBack.onFailed(response.body().toString().trim());
					}
				});
	}


	public void sendReloginBroadCast(){
		Intent intent = new Intent("NEED_RELOGIN_CHICKEN");
		Utils.getContext().sendBroadcast(intent);
	}

	private void writeErrorLog(String filePath, String url, Map<String,String> paramsMap, String token, String content){
		if (FileUtils.createOrExistsFile(filePath)){
			File file = new File(filePath);
			FileIOUtils.writeFileFromString(file,"\r\n",true);
			FileIOUtils.writeFileFromString(file,url,true);
			FileIOUtils.writeFileFromString(file,"\r\n",true);
			if (paramsMap!=null && paramsMap.size()>0){

				StringBuffer sb = new StringBuffer();
				for (Map.Entry<String,String> entry : paramsMap.entrySet()){
					sb.append(entry.getKey()+"="+entry.getValue()+";");
				}
				FileIOUtils.writeFileFromString(file,sb.toString(),true);
			}
			FileIOUtils.writeFileFromString(file,"\r\n"+token+"\r\n",true);
			FileIOUtils.writeFileFromString(file,content,true);
			FileIOUtils.writeFileFromString(file,"..............................................................................................",true);
		}
	}
}
