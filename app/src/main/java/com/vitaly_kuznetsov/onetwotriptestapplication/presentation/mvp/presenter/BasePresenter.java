package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.interactor.UseCase;

import java.util.ArrayList;

abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    private ArrayList<UseCase> useCases = new ArrayList<>();

    void disposeOnDestroy(UseCase useCase) {
        if (useCases!= null && useCase!=null) useCases.add(useCase);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (useCases != null) {
            for (UseCase useCase : useCases) useCase.dispose();
        }
    }

}