package com.cndatacom.databindinglearning.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cndatacom.databindinglearning.R;
import com.cndatacom.databindinglearning.adapter.CommodityAdapter;
import com.cndatacom.databindinglearning.constant.UrlConstant;
import com.cndatacom.databindinglearning.databinding.ActivityComListBinding;
import com.cndatacom.databindinglearning.entity.BaseResponse;
import com.cndatacom.databindinglearning.entity.Commodity;
import com.cndatacom.databindinglearning.impl.ICommodityService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Charlie on 2016/8/5.
 */
public class ComListActivity extends AppCompatActivity {
    private static final String TAG = ComListActivity.class.getSimpleName();

    private List<Commodity> commodities = new ArrayList<Commodity>();

    private CommodityAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityComListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_com_list);

        // 测试
        Commodity commodity = new Commodity();
        commodity.setDescription("描述");
        commodity.setMediaPath("");
        commodity.setProdName("名称");
        commodities.add(commodity);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter = new CommodityAdapter(this, commodities));
        binding.networkRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComListActivity.this.onClick();
            }
        });

    }

    private void onClick() {
        // RxJavaCallAdapterFactory needs com.squareup.retrofit2:adapter-rxjava
        // GsonConverterFactory needs com.squareup.retrofit2:converter-gson
        Retrofit retrofit = new Retrofit.Builder().baseUrl(UrlConstant.BASE_RUL).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
        final ICommodityService service = retrofit.create(ICommodityService.class);
        final long curTime = System.currentTimeMillis();
        Log.v(TAG, "" + curTime);
        service.getComList("logistics_1.0", "android", "" + curTime, "15110909555395800001", "15110915224911700001", "", "", "", 10, 1, "").map(new Func1<BaseResponse<Commodity>, List<Commodity>>() {
            @Override
            public List<Commodity> call(BaseResponse<Commodity> response) {
                return response.getDatas().getItems();
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<Commodity>>() {
            @Override
            public void onCompleted() {
                Toast.makeText(ComListActivity.this, "onCompleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(ComListActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(List<Commodity> commodities) {
                ComListActivity.this.commodities.addAll(commodities);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
