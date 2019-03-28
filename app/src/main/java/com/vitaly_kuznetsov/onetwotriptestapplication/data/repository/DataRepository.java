package com.vitaly_kuznetsov.onetwotriptestapplication.data.repository;

import android.util.Log;

import com.vitaly_kuznetsov.onetwotriptestapplication.data.exception.NetworkConnectionException;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.exception.RestApiException;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.net_connection.InternetConnection;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.controller.ApiRequestController;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.rest_api.post_model.PostModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Company;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Flight;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Hotel;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.repository.Repository;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DataRepository implements Repository {

    private ApiRequestController apiRequestController;
    private CompositeDisposable disposables;

    private PostModel postModel;

    @Override
    public void init() throws Exception {
        disposables = new CompositeDisposable();

        boolean netConnection = InternetConnection.INSTANCE.hasInternetConnection();

        if (netConnection && apiRequestController == null)
            apiRequestController = new ApiRequestController();
        else if (!netConnection) throw new NetworkConnectionException();
    }

    @Override
    public void clear() {
        if (apiRequestController != null) {
            apiRequestController.finish();
            apiRequestController = null;
        }
        dispose();
    }

    @Override
    public ArrayList<Hotel> getHotelsList() throws Exception{
        addDisposable(apiRequestController.getHotelsList()
                .subscribe(result -> postModel = result,
                        throwable -> {throw new RestApiException();}));
        if (postModel == null) throw new RestApiException();
        return postModel.getHotels();
    }

    @Override
    public ArrayList<Flight> getFlightsList() throws Exception{
        addDisposable(apiRequestController.getFlightsList()
                .subscribe(result -> postModel = result,
                        throwable -> {throw new RestApiException();}));
        if (postModel == null) throw new RestApiException();
        return postModel.getFlights();
    }

    @Override
    public ArrayList<Company> getCompaniesList() throws Exception{
        addDisposable(apiRequestController.getCompaniesList()
                .subscribe(result -> postModel = result, throwable -> {throw new RestApiException();}));
        if (postModel == null) throw new RestApiException();
        return postModel.getCompanies();
    }

    private void dispose() {
        if (!disposables.isDisposed()) disposables.dispose();
    }

    private void addDisposable(Disposable disposable) {
        if (disposable != null) disposables.add(disposable); }
}
