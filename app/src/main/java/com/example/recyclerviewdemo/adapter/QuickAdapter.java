package com.example.recyclerviewdemo.adapter;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.recyclerviewdemo.R;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class QuickAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public QuickAdapter(@Nullable List<String> data) {
        super( R.layout.item_bookshelf, data );
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
