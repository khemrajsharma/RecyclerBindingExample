package com.ks.nestedrecyclerbindingexample.callbacks;

import android.view.View;

/**
 * Created by KHEMRAJ on 10/17/2018.
 */
public interface OnItemClickListener<Object> {
    void onItemClick(View view, Object object);
}
