package com.ks.recyclerbindingexample.callbacks;

import android.view.View;

/**
 * Created by KHEMRAJ on 10/17/2018.
 */
public interface OnItemClickListener<Object> {
    void onItemClick(View view, Object object);
}
