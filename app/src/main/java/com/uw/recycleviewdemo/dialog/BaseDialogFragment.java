package com.uw.recycleviewdemo.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.uw.recycleviewdemo.R;

public abstract class BaseDialogFragment extends DialogFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE,getGravity() == Gravity.BOTTOM ? getBottomStyle() : getStyle());
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setCanceledOnTouchOutside(isCancel());
        getDialog().setCancelable(isCancel());
        setDialogParams();
        View view = inflater.inflate(getLayoutId(), container, false);
        bindView(view);
        return view;
    }

    private void setDialogParams() {
        WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        layoutParams.gravity = getGravity();
        layoutParams.height = getHeight();
        layoutParams.width = getWidth();
        getDialog().getWindow().setAttributes(layoutParams);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(getDialog() != null && getDialog().isShowing()){
            getDialog().dismiss();
        }
    }

    protected int getWidth(){
        return WindowManager.LayoutParams.MATCH_PARENT;
    }

    protected int getHeight(){
       return WindowManager.LayoutParams.MATCH_PARENT;
    }

    protected boolean isCancel(){
        return true;
    }

    protected int getGravity(){
        return Gravity.BOTTOM;
    }

    protected  int getStyle(){
        return R.style.CenterDialog;
    }

    protected int getBottomStyle(){
        return R.style.BottomDialog;
    }

    protected abstract void bindView(View view);

    protected abstract int getLayoutId();

}
