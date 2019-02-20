package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mapper;

import com.vitaly_kuznetsov.onetwotriptestapplication.data.server_rest_api.post_models.CompaniesModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.server_rest_api.post_models.FlightsModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.data.server_rest_api.post_models.HotelsModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ChooseFilterModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.DestinationModel;
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel;

public class PostModelMapper {

    public IModel transform(Object postModelElement){

        if (postModelElement instanceof HotelsModel){
            DestinationModel destinationModel = new DestinationModel();
            destinationModel.setDestinationId(((HotelsModel) postModelElement).getId());
            destinationModel.setHotelName(((HotelsModel) postModelElement).getName());
            destinationModel.setAmountOfOptions(((HotelsModel) postModelElement).getFlights().size());
            destinationModel.setPrice(((HotelsModel) postModelElement).getPrice());
            return destinationModel;
        }
        else if (postModelElement instanceof FlightsModel){
            ChooseFilterModel chooseFilterModel = new ChooseFilterModel();
            chooseFilterModel.setId(((FlightsModel) postModelElement).getId());
            chooseFilterModel.setChecked(false);
            chooseFilterModel.setName(((FlightsModel) postModelElement).getDeparture());
            return chooseFilterModel;
        }
        else if (postModelElement instanceof CompaniesModel){
            ChooseFilterModel chooseFilterModel = new ChooseFilterModel();
            chooseFilterModel.setId(((CompaniesModel) postModelElement).getId());
            chooseFilterModel.setChecked(false);
            chooseFilterModel.setName(((CompaniesModel) postModelElement).getName());
            return chooseFilterModel;
        }

        return null;
    }
}
