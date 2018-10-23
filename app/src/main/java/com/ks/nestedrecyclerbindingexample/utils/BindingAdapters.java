package com.ks.nestedrecyclerbindingexample.utils;

import android.databinding.BindingAdapter;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.ks.nestedrecyclerbindingexample.adapters.GeneralAdapter;
import com.ks.nestedrecyclerbindingexample.callbacks.OnItemClickListener;

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
}
