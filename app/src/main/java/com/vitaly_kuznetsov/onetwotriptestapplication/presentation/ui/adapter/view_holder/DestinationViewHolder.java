package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.ui.adapter.view_holder;

import android.view.View;
import android.widget.TextView;

import com.vitaly_kuznetsov.onetwotriptestapplication.R;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.DestinationModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;

import java.util.Locale;

import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.FLIGHT_OPTION_TEXT;
import static com.vitaly_kuznetsov.onetwotriptestapplication.presentation.constants.PresentationConstants.PRICE_TEXT;

public class DestinationViewHolder extends IViewHolder {

    @BindView(R.id.text_view_destination) TextView textViewDestination;
    @BindView(R.id.text_view_flight) TextView textViewFlight;
    @BindView(R.id.text_view_price) TextView textViewPrice;

    public DestinationViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void bind(IModel model){
        if (model instanceof DestinationModel) {
            DestinationModel destinationModel = (DestinationModel) model;
            textViewDestination.setText(destinationModel.getHotelName());

            String string = String.valueOf(destinationModel.getAmountOfOptions()) + FLIGHT_OPTION_TEXT;
            textViewFlight.setText(string);

            double price = destinationModel.getPrice();
            string = String.format(Locale.getDefault(), PRICE_TEXT, price);
            textViewPrice.setText(string);
        }
    }
}
