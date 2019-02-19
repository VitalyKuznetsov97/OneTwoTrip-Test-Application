package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.jakewharton.rxbinding3.view.RxView;
import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter.AdaptUiPresenter;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter.ShowDataPresenter;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IAdaptUiView;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IShowDataView;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.controller.IShowDataController;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.controller.RecyclerViewController;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;

/**
 * Activity to control FilterView.
 */
public class FilterActivity extends MvpAppCompatActivity implements IShowDataView, IAdaptUiView {

    @InjectPresenter
    ShowDataPresenter showDataPresenter;
    @InjectPresenter
    AdaptUiPresenter adaptUiPresenter;

    private IShowDataController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new RecyclerViewController(this);
        ButterKnife.bind(this);
    }

    /**
     * Button Clicks.
     */
    @OnClick(R.id.image_view_go_back) void goToMainView(){ onBackPressed(); }

    @BindView(R.id.image_view_save) ImageView saveFilters;
    public Observable onSaveFiltersClicked(){ return RxView.clicks(saveFilters); }


    public Observable onClearFiltersClicked(){ return }

    @BindView(R.id.button_clear_all_filter) Button clearFilters;
    @Override
    public Observable<Void> onRefreshButtonClicked() {
        return RxView.clicks(clearFilters);
    }

    @Override
    public void adaptUi() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showData(ArrayList data) {

    }

    @Override
    public void showError(ErrorModel errorModel) {

    }

}
