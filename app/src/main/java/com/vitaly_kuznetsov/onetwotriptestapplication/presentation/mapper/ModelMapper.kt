package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mapper

import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.*
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.exception.DefaultErrorBundle
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.ChooseFilterModel
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.DestinationModel
import com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model.IModel

object ModelMapper {

    fun transform(entity: Entity): IModel? {
        return (entity as? Destination)?.let { transform(it) }
                ?: ((entity as? Flight)?.let { transform(it) }
                        ?: if (entity is Company)
                            transform(entity)
                else null)
    }

    private fun transform(destination: Destination): DestinationModel {
        val hotel = destination.hotel

        val destinationModel = DestinationModel()
        destinationModel.destinationId = hotel.id
        destinationModel.hotelName = hotel.name
        destinationModel.amountOfOptions = hotel.flights.size.toString()
        destinationModel.price = destination.lowestPrice

        return destinationModel
    }

    private fun transform(flight: Flight): ChooseFilterModel {
        val chooseFilterModel = ChooseFilterModel()
        chooseFilterModel.id = flight.id
        chooseFilterModel.isChecked = false
        chooseFilterModel.name = flight.departure
        return chooseFilterModel
    }

    private fun transform(company: Company): ChooseFilterModel {
        val chooseFilterModel = ChooseFilterModel()
        chooseFilterModel.id = company.id
        chooseFilterModel.isChecked = false
        chooseFilterModel.name = company.name
        return chooseFilterModel
    }
}
