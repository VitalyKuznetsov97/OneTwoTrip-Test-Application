package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import io.reactivex.Observable;
import kotlin.Unit;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface IRefreshableView extends MvpView {
    Observable<Unit> onRefreshClicked();
}
