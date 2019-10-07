package com.uw.recycleviewdemo.msgviewholder;

import com.uw.recycleviewdemo.entity.AudioBean;
import com.uw.recycleviewdemo.entity.BaseBean;
import com.uw.recycleviewdemo.entity.ImageBean;
import com.uw.recycleviewdemo.entity.TextBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewHoderFactory {

    private static HashMap<Class<? extends BaseBean>,Class<? extends IItemView>> viewHolders = new HashMap<>();

    static {
        register(TextBean.class,TextViewHolder.class);
        register(AudioBean.class,AudioViewHoder.class);
        register(ImageBean.class,ImageViewHolder.class);
    }

    public static void register(Class<? extends BaseBean> bean,Class<? extends IItemView> holder){
        viewHolders.put(bean,holder);
    }

    public static Class<? extends IItemView> getViewHoderType(Class<? extends BaseBean> bean){
        return viewHolders.get(bean);
    }

    public static List<Class<? extends IItemView>> getAllViewHoder(){
        return new ArrayList<>(viewHolders.values());
    }
}
