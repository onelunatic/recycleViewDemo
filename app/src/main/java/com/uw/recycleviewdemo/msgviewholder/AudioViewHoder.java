package com.uw.recycleviewdemo.msgviewholder;

import android.support.annotation.NonNull;
import android.widget.TextView;

import com.uw.recycleviewdemo.R;
import com.uw.recycleviewdemo.adapter.MsgAdapter;
import com.uw.recycleviewdemo.entity.AudioBean;

public class AudioViewHoder extends IItemView<MsgAdapter, AudioBean>{

    public AudioViewHoder(MsgAdapter mBaseAdapter) {
        super(mBaseAdapter);
    }

    @Override
    public int getLayoutId() {
        return  R.layout.item_text;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder mBaseViewHolder, int mI, AudioBean data) {
        TextView textView  = mBaseViewHolder.itemView.findViewById(R.id.tv_text);
        textView.setText(data.getName());
    }

}
