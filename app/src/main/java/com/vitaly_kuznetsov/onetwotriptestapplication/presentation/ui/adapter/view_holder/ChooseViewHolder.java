package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.view_holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ChooseFilterModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseViewHolder extends RecyclerView.ViewHolder implements IViewHolder<ChooseFilterModel> {

    @BindView(R.id.text_view_option) TextView textViewOption;
    @BindView(R.id.checkbox) CheckBox checkBox;

    public ChooseViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(ChooseFilterModel chooseFilterModel){
        if (chooseFilterModel != null) {
            textViewOption.setText(chooseFilterModel.getName());
            checkBox.setChecked(false);
        }
    }

}
