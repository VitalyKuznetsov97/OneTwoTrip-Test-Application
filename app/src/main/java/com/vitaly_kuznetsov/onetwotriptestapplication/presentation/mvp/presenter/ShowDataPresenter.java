package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Entity;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mapper.ModelMapper;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IShowDataView;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.activity.RefreshableView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class ShowDataPresenter extends BasePresenter<IShowDataView> implements IShowDataPresenter{

    private boolean isLoading;
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

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        refreshData();
    }

    /**
     * IShowDataPresenter methods:
     */

    @Override
    public void showData(Entity entity) {
        getViewState().showData(ModelMapper.INSTANCE.transform(entity));
    }

    @Override
    public void onLoadingFinished() {
        isLoading = false;
        getViewState().hideLoading();
    }

    @Override
    public void showError(ErrorModel errorModel) {
        getViewState().showError(errorModel);
    }

    /**
     * Other support methods:
     */
    private void setOnRefreshButtonClickListener(IShowDataView view){
        if (view instanceof RefreshableView) {
            RefreshableView refreshableView = (RefreshableView) view;
            disposableRefreshButton = refreshableView.onRefreshClicked()
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(aVoid -> refreshData(), error -> System.out.println("Error occurred! : " + error));
        }
    }

    private void refreshData(){
        if (isLoading) return;
        else isLoading = true;
        getViewState().showLoading();
    }
}
