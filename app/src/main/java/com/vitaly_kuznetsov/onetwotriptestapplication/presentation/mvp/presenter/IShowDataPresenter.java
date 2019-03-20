package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Entity;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;

/**
 * This interface represents a presenter used by
 * {@link com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter.observer.LoadDataUseCaseObserver}
 */

public interface IShowDataPresenter {

    void showData(Entity entity);
    void showError(ErrorModel errorModel);
    void onLoadingFinished();

}
