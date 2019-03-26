package com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.retrofit_builder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.endpoints.Endpoints.BASE_URL;

public class BasicRetrofitBuilder {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static void disposeRetrofitInstance(){
        retrofit = null;
    }

}
