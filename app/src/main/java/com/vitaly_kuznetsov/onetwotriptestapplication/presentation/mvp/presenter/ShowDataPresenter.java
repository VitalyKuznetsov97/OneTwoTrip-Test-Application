package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.server_rest_api.post_models.PostModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.server_rest_api.request_controller.ApiRequestController;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mapper.PostModelMapper;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IShowDataView;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.activity.RefreshableView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ShowDataPresenter extends BasePresenter<IShowDataView> {

    private boolean isLoading;
    private Disposable loadingDisposable;
    private Disposable disposableRefreshButton;

    private PostModel postModel;
    private ArrayList<IModel> iModels;

    @Override
    public void attachView(IShowDataView view) {
        super.attachView(view);
        setOnRefreshButtonClickListener(view);
    }

    @Override
    public void onDestroy() {
        disposeOnDestroy(disposableRefreshButton);
        super.onDestroy();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        load();
    }

    private void setOnRefreshButtonClickListener(IShowDataView view){
        if (view instanceof RefreshableView) {
            RefreshableView refreshableView = (RefreshableView) view;
            disposableRefreshButton = refreshableView.onRefreshClicked()
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(aVoid -> load(), error -> System.out.println("Error occurred! : " + error));
        }
    }

    private void load(){

        if (isLoading) return;
        else isLoading = true;

        ApiRequestController apiRequestController = new ApiRequestController();
        Observable<PostModel> observable = apiRequestController.getCompaniesList();

        observable
            .delay(2000, TimeUnit.MILLISECONDS, Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<PostModel>() {
                @Override
                public void onSubscribe(Disposable d) {
                    getViewState().showLoading();
                    loadingDisposable = d;
                    disposeOnDestroy(d);
                }

                @Override
                public void onNext(PostModel aPostModel) {
                    postModel = aPostModel;
                }

                @Override
                public void onError(Throwable e) {
                    isLoading = false;
                    getViewState().hideLoading();
                    ErrorModel errorModel = new ErrorModel();
                    errorModel.setErrorMessage(e.getMessage());
                    getViewState().showError(errorModel);
                    removeFromDisposables(loadingDisposable);
                }

                @Override
                public void onComplete() {
                    removeFromDisposables(loadingDisposable);
                    mapData();
                }
            });
    }

    private void mapData(){

        PostModelMapper postModelMapper = new PostModelMapper();

        Observable.fromArray(postModel.getPostModelArray())
                .subscribeOn(Schedulers.computation())
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        loadingDisposable = d;
                        disposeOnDestroy(d);
                        iModels = new ArrayList<>();
                    }

                    @Override
                    public void onNext(Object object) {
                        iModels.add(postModelMapper.transform(object));
                    }

                    @Override
                    public void onError(Throwable e) {
                        isLoading = false;
                        getViewState().hideLoading();
                        ErrorModel errorModel = new ErrorModel();
                        errorModel.setErrorMessage(e.getMessage());
                        getViewState().showError(errorModel);
                        removeFromDisposables(loadingDisposable);
                    }

                    @Override
                    public void onComplete() {
                        removeFromDisposables(loadingDisposable);
                        isLoading = false;
                        getViewState().hideLoading();
                        getViewState().showData(iModels);
                    }
                });
    }

}
