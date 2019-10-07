package com.uw.recycleviewdemo.msgviewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.uw.recycleviewdemo.entity.BaseBean;

import java.util.List;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private IItemView mIItemView;
    private List<? extends BaseBean> mBeans;

    public BaseViewHolder(@NonNull View itemView,IItemView mIItemView,List<? extends BaseBean> mBeans) {
        super(itemView);
        this.mIItemView = mIItemView;
        this.mBeans = mBeans;
    }

    public void onBindViewHolder(@NonNull BaseViewHolder mBaseViewHolder, int mI) {
        mIItemView.onBindViewHolder(mBaseViewHolder,mI,mBeans.get(mI));
    }
}
