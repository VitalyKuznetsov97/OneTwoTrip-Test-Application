package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.activity;

import io.reactivex.Observable;
import kotlin.Unit;

public interface RefreshableView {
    public Observable<Unit> onRefreshClicked();
}
