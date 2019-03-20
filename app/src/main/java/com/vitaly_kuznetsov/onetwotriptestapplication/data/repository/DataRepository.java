package com.vitaly_kuznetsov.onetwotriptestapplication.data.repository;

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
    private boolean netConnection;

    private Scheduler executionScheduler;
    private Scheduler postExecutionScheduler;

    private PostModel postModel;

    @Override
    public boolean init(Scheduler executionScheduler, Scheduler postExecutionScheduler) {
        apiRequestController = new ApiRequestController();
        disposables = new CompositeDisposable();
        this.executionScheduler = executionScheduler;
        this.postExecutionScheduler = postExecutionScheduler;

        addDisposable(InternetConnection.INSTANCE.hasInternetConnection().
                subscribeOn(executionScheduler).
                observeOn(postExecutionScheduler).
                subscribe(
                b -> { netConnection = b; },
                throwable -> {netConnection = false; throwable.printStackTrace();}));

        return netConnection;
    }

    @Override
    public ArrayList<Hotel> getHotelsList() {
        addDisposable(apiRequestController.getHotelsList()
                .subscribeOn(executionScheduler)
                .observeOn(postExecutionScheduler)
                .subscribe(result -> postModel = result, Throwable::printStackTrace));
        return postModel.getHotels();
    }

    @Override
    public ArrayList<Flight> getFlightsList() {
        addDisposable(apiRequestController.getHotelsList()
                .subscribeOn(executionScheduler)
                .observeOn(postExecutionScheduler)
                .subscribe(result -> postModel = result, Throwable::printStackTrace));
        return postModel.getFlights();
    }

    @Override
    public ArrayList<Company> getCompaniesList() {
        addDisposable(apiRequestController.getHotelsList()
                .subscribeOn(executionScheduler)
                .observeOn(postExecutionScheduler)
                .subscribe(result -> postModel = result, Throwable::printStackTrace));
        return postModel.getCompanies();
    }

    public void dispose() {
        if (!disposables.isDisposed()) disposables.dispose(); }

    private void addDisposable(Disposable disposable) {
        if (disposable != null) disposables.add(disposable); }
}
