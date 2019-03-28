package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Entity;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.exception.DefaultErrorBundle;

import java.util.ArrayList;

/**
 * This interface represents a presenter used by
 * {@link ShowDataPresenter.DestinationUseCaseObserver}
 */

public interface IShowDataPresenter {

    void showData(ArrayList<Entity> entities);
    void showError(DefaultErrorBundle errorBundle);
    void onLoadingFinished();

}
