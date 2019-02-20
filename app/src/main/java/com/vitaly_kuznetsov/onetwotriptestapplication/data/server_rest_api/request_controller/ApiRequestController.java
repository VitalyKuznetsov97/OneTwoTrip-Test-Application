package com.vitaly_kuznetsov.onetwotriptestapplication.data.server_rest_api.request_controller;

import com.vitaly_kuznetsov.onetwotriptestapplication.data.server_rest_api.api.RestApi;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.server_rest_api.post_models.PostModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.server_rest_api.retrofit_builders.BasicRetrofitBuilder;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * A base class, that starts http requests
 */
public class ApiRequestController {

    protected RestApi api;

    public ApiRequestController(){
        Retrofit retrofit = BasicRetrofitBuilder.getRetrofitInstance();
        api = retrofit.create(RestApi.class);
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
