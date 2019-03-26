package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IRefreshableView;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IShowDataView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RefreshableShowDataPresenter extends ShowDataPresenter{

    private Disposable disposableRefreshButton;

    /**
     * MVP methods:
     */
    @Override
    public void attachView(IShowDataView view) {
        super.attachView(view);
        setOnRefreshButtonClickListener(view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposableRefreshButton != null)
            disposableRefreshButton.dispose();
    }

    /**
     * Other support methods:
     */
    private void setOnRefreshButtonClickListener(IShowDataView view){
        if (view instanceof IRefreshableView) {
            IRefreshableView refreshableView = (IRefreshableView) view;
            disposableRefreshButton = refreshableView.onRefreshClicked()
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(aVoid -> refreshData(), error -> System.out.println("Error occurred! : " + error));
        }
    }
}
