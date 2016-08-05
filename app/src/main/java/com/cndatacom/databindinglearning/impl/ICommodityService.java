package com.cndatacom.databindinglearning.impl;

import com.cndatacom.databindinglearning.entity.BaseResponse;
import com.cndatacom.databindinglearning.entity.Commodity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Charlie on 2016/8/5.
 */
public interface ICommodityService {
    @FormUrlEncoded
    @POST("ware/mall/getWareListInfo.json")
    Observable<BaseResponse<Commodity>> getComList(@Field("appId") String appId, @Field("clientType") String clientType, @Field("timestamp") String timestamp, @Field("parentId") String parentId, @Field("conId") String conId, @Field("specificationId") String specificationId, @Field("speciesColumnValue") String speciesColumnValue, @Field("orderBy") String orderBy, @Field("num") int num, @Field("pageIndex") int pageIndex, @Field("prodBrand") String prodBrand);
}
