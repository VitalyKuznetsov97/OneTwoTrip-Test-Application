package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * An Interface to initialize all buttons, textFields, etc.
 * Moxy library is used for MVP.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface IAdaptUiView extends MvpView {
    void adaptUi();
}
