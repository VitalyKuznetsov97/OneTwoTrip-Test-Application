package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model;

/**
 * Class that represents destination in the presentation layer.
 */

public class DestinationModel implements IModel {

    private int destinationId;
    private String hotelName;
    private int amountOfOptions;
    private int price;

    public int getDestinationId() { return destinationId; }

    public void setDestinationId(int destinationId) { this.destinationId = destinationId; }

    public String getHotelName() { return hotelName; }

    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public int getAmountOfOptions() { return amountOfOptions; }

    public void setAmountOfOptions(int amountOfOptions) { this.amountOfOptions = amountOfOptions; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

}