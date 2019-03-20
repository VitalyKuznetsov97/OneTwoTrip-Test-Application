package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter.observer;

import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Entity;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter.IShowDataPresenter;

import io.reactivex.observers.DisposableObserver;

public class LoadDataUseCaseObserver extends DisposableObserver<Entity> {

    private IShowDataPresenter presenter;

    public LoadDataUseCaseObserver(IShowDataPresenter presenter) {
        this.presenter = presenter;
    }

    @Override public void onComplete() {
        presenter.onLoadingFinished();
    }

    @Override public void onError(Throwable e) {
        presenter.onLoadingFinished();
        ErrorModel errorModel = new ErrorModel();
        errorModel.setErrorMessage(e.getMessage());
        presenter.showError(errorModel);
    }

    @Override public void onNext(Entity entity) {
        presenter.showData(entity);
    }

}
