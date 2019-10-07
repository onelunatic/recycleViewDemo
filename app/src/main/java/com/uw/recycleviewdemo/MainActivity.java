package com.uw.recycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.uw.recycleviewdemo.adapter.MsgAdapter;
import com.uw.recycleviewdemo.entity.AudioBean;
import com.uw.recycleviewdemo.entity.BaseBean;
import com.uw.recycleviewdemo.entity.ImageBean;
import com.uw.recycleviewdemo.entity.TextBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MsgAdapter mMsgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rlv_test);
        List<BaseBean> list = new ArrayList<>();

        list.add(new AudioBean("我是音频type"));
        list.add(new ImageBean("我是图片type"));
        list.add(new TextBean("我是文本type"));
        mMsgAdapter = new MsgAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mMsgAdapter);
    }
}
