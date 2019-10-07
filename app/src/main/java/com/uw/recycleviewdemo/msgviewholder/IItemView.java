package com.uw.recycleviewdemo.msgviewholder;

import android.support.annotation.NonNull;

import com.uw.recycleviewdemo.adapter.BaseAdapter;

public abstract class IItemView <T extends BaseAdapter,K>{

    private T mBaseAdapter;

    public IItemView(T mBaseAdapter){
        this.mBaseAdapter = mBaseAdapter;
    }

    public  abstract int getLayoutId();

    public  abstract void onBindViewHolder(@NonNull BaseViewHolder mBaseViewHolder, int mI,K data);
}
