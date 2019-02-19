package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.controller;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.RecyclerViewAdapter;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.custom_view.CustomProgressBar;

import java.util.ArrayList;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewController implements IShowDataController {

    @BindView(R.id.recycler_view) private RecyclerView recyclerView;
    @BindView(R.id.constraint_main) private ConstraintLayout constraintLayout;

    private ProgressBar progressBar;

    public RecyclerViewController(Activity activity) {
        ButterKnife.bind(activity);
        recyclerView.setAdapter(new RecyclerViewAdapter());
    }

    @Override
    public void showData(ArrayList data) {

    }

    @Override
    public void showLoading(Context context) {
        progressBar = new CustomProgressBar(recyclerView, context, null, android.R.attr.progressBarStyle);
        recyclerView.setVisibility(View.INVISIBLE);
        constraintLayout.addView(progressBar);
    }

    @Override
    public void hideLoading() {
        if (progressBar != null)
            constraintLayout.removeView(progressBar);

        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(ErrorModel errorModel) {

    }
}