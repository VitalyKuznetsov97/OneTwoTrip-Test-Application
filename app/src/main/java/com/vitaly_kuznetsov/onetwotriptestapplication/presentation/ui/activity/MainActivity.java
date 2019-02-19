package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.activity;

import android.os.Bundle;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.jakewharton.rxbinding3.view.RxView;
import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter.AdaptUiPresenter;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter.ShowDataPresenter;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IAdaptUiView;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IShowDataView;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.navigation.Navigator;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.controller.IShowDataController;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.controller.RecyclerViewController;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;

import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.INTENT_FLAG_COMPANIES;
import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.INTENT_FLAG_HOTELS;

public class MainActivity extends MvpAppCompatActivity implements IShowDataView, IAdaptUiView {

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

    @Override
    public void adaptUi() {

    }

    /**
     * Button Clicks.
     */

    @OnClick(R.id.text_view_hotels)
    public void goToHotelsFilter(){ Navigator.navigateToFilterActivity(this, INTENT_FLAG_HOTELS); }

    @OnClick(R.id.text_view_companies)
    public void goToCompaniesFilter(){ Navigator.navigateToFilterActivity(this, INTENT_FLAG_COMPANIES); }

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

    @Override
    public Observable<Void> onRefreshButtonClicked() {
        return null;
    }
}