package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.controller;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.RecyclerViewAdapter;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.custom_view.CustomProgressBar;

import java.util.ArrayList;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewController implements IShowDataController {

    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.constraint_main) ConstraintLayout constraintLayout;

    private ProgressBar progressBar;

    private RecyclerViewAdapter adapter;

    public RecyclerViewController(Activity activity) {
        ButterKnife.bind(this, activity);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showData(IModel model) {
        adapter.showData(model);
    }

    @Override
    public void showLoading(Context context) {
        progressBar = new CustomProgressBar(recyclerView, context, null, android.R.attr.progressBarStyle);
        recyclerView.setVisibility(View.INVISIBLE);
        constraintLayout.addView(progressBar);
    }

    @Override
    public void hideLoading() {
        if (progressBar != null) constraintLayout.removeView(progressBar);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(ErrorModel errorModel) {
        adapter.showError(errorModel);
    }
}