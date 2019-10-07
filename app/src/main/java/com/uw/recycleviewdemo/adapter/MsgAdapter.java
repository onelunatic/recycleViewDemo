package com.uw.recycleviewdemo.adapter;

import com.uw.recycleviewdemo.entity.BaseBean;
import com.uw.recycleviewdemo.msgviewholder.IItemView;
import com.uw.recycleviewdemo.msgviewholder.ViewHoderFactory;

import java.util.List;

public class MsgAdapter extends BaseAdapter{

    public MsgAdapter(List<? extends BaseBean> mData) {
        super(mData);
    }

    @Override
    protected <T extends BaseAdapter> T getAdapter() {
        return (T) this;
    }


    @Override
    protected List<Class<? extends IItemView>> getIItemViewList() {
        return ViewHoderFactory.getAllViewHoder();
    }
}
