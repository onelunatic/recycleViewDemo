package com.uw.recycleviewdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.uw.recycleviewdemo.entity.BaseBean;
import com.uw.recycleviewdemo.msgviewholder.BaseViewHolder;
import com.uw.recycleviewdemo.msgviewholder.IItemView;
import com.uw.recycleviewdemo.msgviewholder.ViewHoderFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<? extends BaseBean> mData;

    private HashMap<Class<? extends IItemView>,Integer> mHashMap = new HashMap<>();
    private SparseArray<Class<? extends IItemView>> holderClasses = new SparseArray<>();

    public BaseAdapter(List<? extends BaseBean> mData){
        this.mData = mData;
        List<Class<? extends IItemView>> viewHolders = getIItemViewList();
        for (int i=0;i<viewHolders.size();i++){
            mHashMap.put(viewHolders.get(i),i);
            holderClasses.put(i,viewHolders.get(i));
        }
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup mViewGroup, int mI) {
        try {
            Class<? extends IItemView> viewClazz = holderClasses.get(mI);
            Constructor constructor = viewClazz.getConstructors()[0];
            IItemView iItemView = (IItemView) constructor.newInstance(getAdapter());
            return new BaseViewHolder(LayoutInflater.from(mViewGroup.getContext()).inflate(iItemView.getLayoutId(),mViewGroup,false),iItemView,mData);
        }  catch (IllegalAccessException mE) {
            mE.printStackTrace();
        } catch (InstantiationException mE) {
            mE.printStackTrace();
        } catch (InvocationTargetException mE) {
            mE.printStackTrace();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder mBaseViewHolder, int mI) {
        mBaseViewHolder.onBindViewHolder(mBaseViewHolder,mI);
    }

    @Override
    public int getItemViewType(int position) {
        return mHashMap.get(ViewHoderFactory.getViewHoderType(mData.get(position).getClass()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    protected abstract <T extends BaseAdapter>T getAdapter();

    protected abstract List<Class<? extends IItemView>> getIItemViewList();

}
