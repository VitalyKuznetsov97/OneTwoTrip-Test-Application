package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.view_holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ChooseFilterModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;

import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseViewHolder extends IViewHolder {

    @BindView(R.id.text_view_option) TextView textViewOption;
    @BindView(R.id.checkbox) CheckBox checkBox;

    public ChooseViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(IModel model) {
        if (model instanceof ChooseFilterModel){
            ChooseFilterModel chooseFilterModel = (ChooseFilterModel) model;
            textViewOption.setText(chooseFilterModel.getName());
            checkBox.setChecked(false);
        }
    }

}
