package com.tgjs.dql.mymvpdemo.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.tgjs.dql.mymvpdemo.R;
import com.tgjs.dql.mymvpdemo.entity.IndexEntity;


import java.util.List;

/**
 * Created by 王松 on 2016/10/8.
 */

public class MyAdapter extends BaseQuickAdapter<IndexEntity.DataBean,BaseViewHolder> {

    public MyAdapter(@Nullable List<IndexEntity.DataBean> data) {
        super(R.layout.listview_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, IndexEntity.DataBean item) {
        Picasso.with(mContext).load(item.getImagePath()).centerCrop().resizeDimen(R.dimen.iv_width,R.dimen.iv_width).into((ImageView) helper.getView(R.id.iv));
        helper.setText(R.id.description,item.getTitle());
    }
}
