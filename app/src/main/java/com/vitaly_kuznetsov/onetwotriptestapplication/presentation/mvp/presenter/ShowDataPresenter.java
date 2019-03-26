package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Entity;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.exception.DefaultErrorBundle;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.exception.ErrorBundle;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mapper.ModelMapper;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IShowDataView;

import java.util.ArrayList;

@InjectViewState
public class ShowDataPresenter extends BasePresenter<IShowDataView> implements IShowDataPresenter{

    private boolean isLoading;

    /**
     * MVP methods:
     */
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        refreshData();
    }

    /**
     * IShowDataPresenter methods:
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
    public void showError(ErrorBundle errorBundle) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setErrorMessage(errorBundle.getErrorMessage());
        getViewState().showError(errorModel);
    }

    /**
     * Other support methods:
     */
    void refreshData(){
        if (isLoading) return;
        else isLoading = true;
        getViewState().showLoading();
    }
}
