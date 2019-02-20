package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.view_holder;

import android.view.View;
import android.widget.TextView;

import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.DestinationModel;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DestinationViewHolder extends RecyclerView.ViewHolder implements IViewHolder<DestinationModel> {

    @BindView(R.id.text_view_destination) TextView textViewDestination;
    @BindView(R.id.text_view_flight) TextView textViewFlight;
    @BindView(R.id.text_view_price) TextView textViewPrice;

    public DestinationViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(DestinationModel destinationModel){
        if (destinationModel != null) {
            textViewDestination.setText(destinationModel.getHotelName());
            textViewFlight.setText(destinationModel.getAmountOfOptions());
            textViewPrice.setText(destinationModel.getPrice());
        }
    }
}
