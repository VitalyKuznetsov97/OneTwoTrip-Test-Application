package com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.api;

import com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.post_model.PostModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

import static com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.endpoints.Endpoints.COMPANY_ENDPOINT;
import static com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.endpoints.Endpoints.FLIGHT_ENDPOINT;
import static com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.endpoints.Endpoints.HOTEL_ENDPOINT;

public interface RestApi {

    @GET(HOTEL_ENDPOINT)
    Observable<PostModel> getHotelsList();

    @GET(FLIGHT_ENDPOINT)
    Observable<PostModel> getFlightsList();

    @GET(COMPANY_ENDPOINT)
    Observable<PostModel> getCompaniesList();
}
