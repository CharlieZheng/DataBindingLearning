package com.cndatacom.databindinglearning.holder;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cndatacom.databindinglearning.databinding.ItemCommodityBinding;
import com.cndatacom.databindinglearning.entity.Commodity;

/**
 * Created by Charlie on 2016/8/5.
 */
public class CommodityHolder extends RecyclerView.ViewHolder {
    private ItemCommodityBinding binding;

    public CommodityHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

    public void bind(Commodity item) {
        binding.setCommodity(item);
    }
}
