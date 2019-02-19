package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import io.reactivex.disposables.Disposable;

class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    private ArrayList<Disposable> disposables = new ArrayList<>();

    void unsubscribeOnDestroy(@NonNull Disposable disposable) {
        disposables.add(disposable);
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