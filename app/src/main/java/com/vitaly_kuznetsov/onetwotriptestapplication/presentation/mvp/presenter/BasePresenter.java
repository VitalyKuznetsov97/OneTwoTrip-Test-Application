package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;

abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    private ArrayList<Disposable> disposables = new ArrayList<>();

    void disposeOnDestroy(Disposable disposable) {
        if (disposable!=null) disposables.add(disposable);
    }
    void removeFromDisposables(Disposable disposable){
        if (disposable!=null) disposables.remove(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposables != null) {
            for (Disposable disposable : disposables) disposable.dispose();
            disposables = null;
        }
    }

}