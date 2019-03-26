package com.vitaly_kuznetsov.onetwotriptestapplication.data.repository;

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

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DataRepository implements Repository {

    private ApiRequestController apiRequestController;
    private CompositeDisposable disposables;

    private Scheduler executionScheduler;
    private Scheduler postExecutionScheduler;

    private PostModel postModel;

    @Override
    public void init(Scheduler executionScheduler, Scheduler postExecutionScheduler) throws Exception {
        disposables = new CompositeDisposable();
        this.executionScheduler = executionScheduler;
        this.postExecutionScheduler = postExecutionScheduler;

        final boolean[] netConnection = new boolean[1];

        addDisposable(InternetConnection.INSTANCE.hasInternetConnection().
                subscribeOn(executionScheduler).
                observeOn(postExecutionScheduler).
                subscribe(
                b -> netConnection[0] = b,
                throwable -> {throw new NetworkConnectionException();}));

        if (netConnection[0]) apiRequestController = new ApiRequestController();
        else throw new NetworkConnectionException();
    }

    @Override
    public void clear() {
        apiRequestController.finish();
        dispose();
    }

    @Override
    public ArrayList<Hotel> getHotelsList() throws Exception{
        addDisposable(apiRequestController.getHotelsList()
                .subscribeOn(executionScheduler)
                .observeOn(postExecutionScheduler)
                .subscribe(result -> postModel = result, throwable -> {throw new RestApiException();}));
        return postModel.getHotels();
    }

    @Override
    public ArrayList<Flight> getFlightsList() throws Exception{
        addDisposable(apiRequestController.getHotelsList()
                .subscribeOn(executionScheduler)
                .observeOn(postExecutionScheduler)
                .subscribe(result -> postModel = result, throwable -> {throw new RestApiException();}));
        return postModel.getFlights();
    }

    @Override
    public ArrayList<Company> getCompaniesList() throws Exception{
        addDisposable(apiRequestController.getHotelsList()
                .subscribeOn(executionScheduler)
                .observeOn(postExecutionScheduler)
                .subscribe(result -> postModel = result, throwable -> {throw new RestApiException();}));
        return postModel.getCompanies();
    }

    private void dispose() {
        if (!disposables.isDisposed()) disposables.dispose();
    }

    private void addDisposable(Disposable disposable) {
        if (disposable != null) disposables.add(disposable); }
}
