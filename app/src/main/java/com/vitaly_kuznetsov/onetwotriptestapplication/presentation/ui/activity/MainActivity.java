package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.activity;

import android.os.Bundle;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.jakewharton.rxbinding3.view.RxView;
import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.presenter.ShowDataPresenter;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.view.IShowDataView;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.navigation.Navigator;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.controller.IShowDataController;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.controller.RecyclerViewController;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import kotlin.Unit;

import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.INTENT_FLAG_COMPANIES;
import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.INTENT_FLAG_HOTELS;

public class MainActivity extends MvpAppCompatActivity implements IShowDataView, RefreshableView {

    @InjectPresenter
    ShowDataPresenter showDataPresenter;

    private IShowDataController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new RecyclerViewController(this);
        ButterKnife.bind(this);
    }

    /**
     * IRefreshableShowDataView Methods.
     */
    @Override
    public void showLoading() {
        controller.showLoading(this);
    }

    @Override
    public void hideLoading() {
        controller.hideLoading();
    }

    @Override
    public void showData(IModel model) {
        controller.showData(model);
    }

    @Override
    public void showError(ErrorModel errorModel) {
        controller.showError(errorModel);
    }

    /**
     * Button Clicks.
     */
    @BindView(R.id.button_refresh) Button refreshButton;
    @Override public Observable<Unit> onRefreshClicked() {
        return RxView.clicks(refreshButton);
    }

    @OnClick(R.id.text_view_hotels)
    public void goToHotelsFilter(){ Navigator.navigateToFilterActivity(this, INTENT_FLAG_HOTELS); }

    @OnClick(R.id.text_view_companies)
    public void goToCompaniesFilter(){ Navigator.navigateToFilterActivity(this, INTENT_FLAG_COMPANIES); }
}