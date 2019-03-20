package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IAdaptUiView;

@InjectViewState
public class AdaptUiPresenter extends BasePresenter<IAdaptUiView> {

    @Override
    public void attachView(IAdaptUiView view) {
        super.attachView(view);
        view.adaptUi();
    }

}
