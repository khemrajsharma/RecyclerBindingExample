package com.ks.recyclerbindingexample.utils;

import android.databinding.BindingAdapter;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ks.recyclerbindingexample.adapters.GeneralAdapter;
import com.ks.recyclerbindingexample.callbacks.OnItemClickListener;

import java.util.List;

/**
 * Created by KHEMRAJ on 10/23/2018.
 */
public class BindingAdapters {
    @BindingAdapter(value = {"rvItemLayout", "rvList", "rvOnItemClick"}, requireAll = false)
    public static void setRvAdapter(RecyclerView recyclerView, int rvItemLayout, List rvList, @Nullable OnItemClickListener onItemClickListener) {
        if (rvItemLayout != 0 && rvList != null && rvList.size() > 0)
            recyclerView.setAdapter(new GeneralAdapter(rvItemLayout, rvList, onItemClickListener));
    }

    @BindingAdapter("android:visible")
    public static void setVisibilityByBoolean(View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }
}
