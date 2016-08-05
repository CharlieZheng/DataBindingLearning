package com.cndatacom.databindinglearning.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cndatacom.databindinglearning.R;
import com.cndatacom.databindinglearning.entity.Commodity;
import com.cndatacom.databindinglearning.holder.CommodityHolder;

import java.util.List;

/**
 * Created by Charlie on 2016/8/5.
 */
public class CommodityAdapter extends RecyclerView.Adapter<CommodityHolder> {
    private Activity activity;
    private List<Commodity> commodities;
    private LayoutInflater layoutInflater;

    public CommodityAdapter(Activity activity, List<Commodity> commodities) {
        this.activity = activity;
        this.commodities = commodities;
        this.layoutInflater = LayoutInflater.from(activity);
    }

    @Override
    public CommodityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_commodity, null, false);
        CommodityHolder holder = new CommodityHolder(view);
        //        switch (CommodityType.values()[viewType]) {
        //            case NORMAL:
        //                break;
        //            case BARGAIN:
        //                break;
        //        }
        return holder;
    }

    @Override
    public void onBindViewHolder(CommodityHolder holder, int position) {
        Commodity item = commodities.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return commodities.size();
    }
}
