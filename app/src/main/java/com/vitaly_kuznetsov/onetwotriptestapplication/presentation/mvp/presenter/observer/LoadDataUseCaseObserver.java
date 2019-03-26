package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter.observer;

import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Entity;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.exception.DefaultErrorBundle;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.exception.ErrorBundle;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter.IShowDataPresenter;

import java.util.ArrayList;

import io.reactivex.observers.DisposableObserver;

public class LoadDataUseCaseObserver extends DisposableObserver<ArrayList<Entity>> {

    private IShowDataPresenter presenter;

    public LoadDataUseCaseObserver(IShowDataPresenter presenter) {
        this.presenter = presenter;
    }

    @Override public void onComplete() {
        presenter.onLoadingFinished();
    }

    @Override public void onError(Throwable e) {
        presenter.onLoadingFinished();
        presenter.showError((ErrorBundle) e);
    }

    @Override public void onNext(ArrayList<Entity> entities) {
        presenter.showData(entities);
    }

}
