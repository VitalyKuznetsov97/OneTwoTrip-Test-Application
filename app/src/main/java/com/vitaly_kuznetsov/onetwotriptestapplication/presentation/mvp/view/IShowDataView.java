package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;

/**
 * An Interface to show that the view is currently not available, due to some asynchronous work,
 * or to show the result of this work.
 * Moxy library is used for MVP.
 */
@StateStrategyType(SingleStateStrategy.class)
public interface IShowDataView extends MvpView {

    /**
     * Loading Methods.
     * Show a view with a progress bar indicating a loading process.
     */
    void showLoading();

    /**
     * Hide a loading view.
     */
    void hideLoading();

    /**
     * Render data.
     */
    void showData(IModel data);

    /**
     * Show an error message
     * @param errorModel of type {@link ErrorModel} representing an error.
     */
    void showError(ErrorModel errorModel);

}
