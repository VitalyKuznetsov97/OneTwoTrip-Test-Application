package com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.controller;

import com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.api.RestApi;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.post_model.PostModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.retrofit_builder.BasicRetrofitBuilder;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * A base class, that starts http requests
 */
public class ApiRequestController {

    private RestApi api;

    public ApiRequestController(){
        Retrofit retrofit = BasicRetrofitBuilder.getRetrofitInstance();
        api = retrofit.create(RestApi.class);
    }

    public void finish(){
        BasicRetrofitBuilder.disposeRetrofitInstance();
    }

    public Observable<PostModel> getHotelsList(){
        return api.getHotelsList();
    }

    public Observable<PostModel> getFlightsList(){
        return api.getFlightsList();
    }

    public Observable<PostModel> getCompaniesList(){
        return api.getCompaniesList();
    }
}
