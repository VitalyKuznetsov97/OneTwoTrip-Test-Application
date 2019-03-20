package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.view_holder;

import android.view.View;
import android.widget.TextView;

import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ErrorViewHolder extends IViewHolder {

    @BindView(R.id.text_view_option) TextView textViewOption;

    public ErrorViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(IModel model) {
        if (model instanceof ErrorModel) {
            ErrorModel errorModel = (ErrorModel) model;
            if (errorModel.getErrorMessage() != null)
                textViewOption.setText(errorModel.getErrorMessage());
        }
    }

}
