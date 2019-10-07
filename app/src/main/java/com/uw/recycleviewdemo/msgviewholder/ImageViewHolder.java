package com.uw.recycleviewdemo.msgviewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.uw.recycleviewdemo.R;
import com.uw.recycleviewdemo.adapter.BaseAdapter;
import com.uw.recycleviewdemo.adapter.MsgAdapter;
import com.uw.recycleviewdemo.entity.AudioBean;
import com.uw.recycleviewdemo.entity.ImageBean;

public class ImageViewHolder extends IItemView<MsgAdapter, ImageBean>{

    public ImageViewHolder(MsgAdapter mBaseAdapter) {
        super(mBaseAdapter);
    }

    @Override
    public int getLayoutId() {
        return  R.layout.item_text;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder mBaseViewHolder, int mI, ImageBean data) {
        TextView textView  = mBaseViewHolder.itemView.findViewById(R.id.tv_text);
        textView.setText(data.getName());
    }

}
