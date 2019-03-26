package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Entity;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.exception.ErrorBundle;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;

import java.util.ArrayList;

/**
 * This interface represents a presenter used by
 * {@link com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter.observer.LoadDataUseCaseObserver}
 */

public interface IShowDataPresenter {

    void showData(ArrayList<Entity> entities);
    void showError(ErrorBundle errorBundle);
    void onLoadingFinished();

}
