package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IShowDataView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ShowDataPresenter extends BasePresenter<IShowDataView> {

    private boolean isLoading;
    private Disposable disposableRefreshButton;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        load();
    }

    @Override
    public void attachView(IShowDataView view) {
        super.attachView(view);
        setOnRefreshButtonClickListener(view);
    }

    @Override
    public void onDestroy() {
        unsubscribeOnDestroy(disposableRefreshButton);
        super.onDestroy();
    }

    private void setOnRefreshButtonClickListener(IShowDataView view){
        disposableRefreshButton = view.onRefreshButtonClicked()
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(aVoid -> load(), error -> System.out.println("Error occurred! : " + error));
    }

    private void load(){

        if (isLoading) return;
        else isLoading = true;

        Observable.just("Hey!")
                .delay(2000, TimeUnit.MILLISECONDS, Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        getViewState().showLoading();
                    }

                    @Override
                    public void onNext(String s) {}

                    @Override
                    public void onError(Throwable e) {
                        isLoading = false;
                        getViewState().hideLoading();
                        getViewState().showError(new ErrorModel("Error"));
                    }

                    @Override
                    public void onComplete() {
                        isLoading = false;
                        getViewState().hideLoading();
                        getViewState().showData(new ArrayList());
                    }
                });
    }

}
