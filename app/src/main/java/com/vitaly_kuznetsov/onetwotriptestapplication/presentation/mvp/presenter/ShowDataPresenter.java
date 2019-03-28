package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.repository.DataRepository;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Entity;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.exception.DefaultErrorBundle;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.interactor.DefaultObserver;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.interactor.ShowDestinationUseCase;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mapper.ModelMapper;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IShowDataView;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.thread.UIThread;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.thread.UseCaseExecutionThread;

import java.util.ArrayList;

@InjectViewState
public class ShowDataPresenter extends BasePresenter<IShowDataView> implements IShowDataPresenter {

    private boolean isLoading;
    private ShowDestinationUseCase showDestinationUseCase;

    /**
     * MVP methods:
     */
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        showDestinationUseCase = new ShowDestinationUseCase(
                new DataRepository(), new UseCaseExecutionThread(), new UIThread());
        disposeOnDestroy(showDestinationUseCase);
        refreshData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * IShowDataPresenter methods:
     * @param entities is later to be transformed into a correct data structure.
     */
    @Override
    public void showData(ArrayList<Entity> entities) {
        ArrayList<IModel> iModels = new ArrayList<>();
        for (Entity entity : entities) iModels.add(ModelMapper.INSTANCE.transform(entity));
        getViewState().showData(iModels);
    }

    @Override
    public void onLoadingFinished() {
        isLoading = false;
        getViewState().hideLoading();
    }

    @Override
    public void showError(DefaultErrorBundle errorBundle) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setErrorMessage(errorBundle.getErrorMessage());
        getViewState().showError(errorModel);
    }

    /**
     * UseCase commands:
     */
    private void showDestinations(){
        showDestinationUseCase.execute(new LoadDataUseCaseObserver(this), null);
    }

    private final class LoadDataUseCaseObserver extends DefaultObserver<ArrayList<Entity>> {

        private IShowDataPresenter presenter;

        LoadDataUseCaseObserver(IShowDataPresenter presenter) {
            this.presenter = presenter;
        }

        @Override public void onComplete() {
            presenter.onLoadingFinished();
        }

        @Override public void onError(Throwable e) {
            presenter.onLoadingFinished();
            DefaultErrorBundle errorBundle = new DefaultErrorBundle((Exception) e);
            presenter.showError(errorBundle);
        }

        @Override public void onNext(ArrayList<Entity> entities) {
            presenter.showData(entities);
        }

    }

    /**
     * Other support methods:
     */
    void refreshData(){
        if (isLoading) return;
        else isLoading = true;
        getViewState().showLoading();
        showDestinations();
    }
}
