package com.ks.nestedrecyclerbindingexample.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ks.nestedrecyclerbindingexample.BR;
import com.ks.nestedrecyclerbindingexample.callbacks.OnItemClickListener;
import com.ks.nestedrecyclerbindingexample.models.BaseModel;

import java.util.List;

/**
 * Created by sud on 12/23/2017.
 */

/* general recyclerview adapter */

public class GeneralAdapter<T extends BaseModel> extends RecyclerView.Adapter<GeneralAdapter.GRViewHolder> {

    private final List<T> itemList;
    public OnItemClickListener onItemClickListener;
    @LayoutRes
    private int itemLayout;

    public GeneralAdapter(@LayoutRes int itemLayout, List<T> itemList, OnItemClickListener onItemClickListener) {
        this.itemList = itemList;
        this.onItemClickListener = onItemClickListener;
        this.itemLayout = itemLayout;
    }

    public GeneralAdapter(@LayoutRes int itemLayout, List<T> itemList) {
        this.itemList = itemList;
        this.itemLayout = itemLayout;
    }

    public List<T> getItemList() {
        return itemList;
    }

    public void add(List<T> newList) {
        if (newList != null && !newList.isEmpty()) {
            int oldSize = getItemList().size();
            getItemList().addAll(newList);
            notifyItemRangeChanged(oldSize - 1, newList.size());
        }
    }

    public void add(T item) {
        itemList.add(item);
        notifyItemInserted(itemList.size() - 1);
    }

    public void add(T item, int position) {
        if (position > 0 && position <= getItemList().size()) {
            getItemList().add(item);
            notifyItemInserted(position);
        }
    }

    public void remove(int position) {
        if (position > 0 && position < getItemList().size()) {
            getItemList().remove(position);
            notifyItemRemoved(position);
        }
    }

    public void remove(T item) {
        int position = getItemList().indexOf(item);
        if (position >= 0 && position < getItemList().size()) {
            getItemList().remove(position);
            notifyItemRemoved(position);
        }
    }

    public void removeAll() {
        if (itemList == null) return;
        int oldSize = getItemList().size();
        getItemList().clear();
        notifyItemRangeRemoved(0, oldSize);
    }

    @Override
    public GeneralAdapter.GRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new GeneralAdapter.GRViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GeneralAdapter.GRViewHolder holder, int position) {
        holder.binding.setVariable(BR.model, itemList.get(position));
        if (onItemClickListener != null) {
            holder.binding.setVariable(BR.onItemClickListener, onItemClickListener);
        }
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class GRViewHolder extends RecyclerView.ViewHolder {

        ViewDataBinding binding;

        GRViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
