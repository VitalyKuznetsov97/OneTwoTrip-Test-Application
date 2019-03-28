package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IRefreshableView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class RefreshableViewPresenter extends BasePresenter<IRefreshableView>{

    private ShowDataPresenter showDataPresenter;
    private Disposable disposableRefreshButton;

    public void init(ShowDataPresenter showDataPresenter){
        this.showDataPresenter = showDataPresenter;
    }

    /**
     * MVP methods:
     */
    @Override
    public void attachView(IRefreshableView view) {
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
    private void setOnRefreshButtonClickListener(IRefreshableView view){
        disposableRefreshButton = view.onRefreshClicked()
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(aVoid -> showDataPresenter.refreshData(), Throwable::printStackTrace);

    }
}
