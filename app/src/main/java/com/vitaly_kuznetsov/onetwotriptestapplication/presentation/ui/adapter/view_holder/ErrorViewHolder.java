package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.view_holder;

import android.view.View;
import android.widget.TextView;

import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ErrorModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ErrorViewHolder extends RecyclerView.ViewHolder implements IViewHolder<ErrorModel> {

    @BindView(R.id.text_view_option) TextView textViewOption;

    public ErrorViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(ErrorModel errorModel){
        if (errorModel != null && errorModel.getErrorMessage() != null)
            textViewOption.setText(errorModel.getErrorMessage());
    }

}
