package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;
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

import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.COMPANIES_TEXT;
import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.HOTELS_TEXT;
import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.INTENT_FLAG_HOTELS;
import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.INTENT_FLAG_NAME;

/**
 * Activity to control FilterView.
 */
public class FilterActivity extends MvpAppCompatActivity implements IShowDataView, IAdaptUiView {

    @InjectPresenter ShowDataPresenter showDataPresenter;
    @InjectPresenter AdaptUiPresenter adaptUiPresenter;

    private IShowDataController controller;

    private int filterFlag;
    @BindView(R.id.text_view_filter_name) TextView filterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new RecyclerViewController(this);
        ButterKnife.bind(this);
        filterFlag = getIntent().getIntExtra(INTENT_FLAG_NAME, 0);
    }

    /**
     * IAdaptUi Methods.
     */
    @Override public void adaptUi() {
        filterName.setText(filterFlag == INTENT_FLAG_HOTELS ? HOTELS_TEXT : COMPANIES_TEXT);
    }

    /**
     * IShowDataView Methods.
     */
    @Override public void showLoading() {
        controller.showLoading(this);
    }

    @Override public void hideLoading() {
        controller.hideLoading();
    }

    @Override public void showData(ArrayList<IModel> iModels) {
        controller.showData(iModels);
    }

    @Override public void showError(ErrorModel errorModel) {
        controller.showError(errorModel);
    }

    /**
     * Button Clicks.
     */
    @OnClick(R.id.image_view_go_back) void goBackClicked(){ onBackPressed(); }
}
