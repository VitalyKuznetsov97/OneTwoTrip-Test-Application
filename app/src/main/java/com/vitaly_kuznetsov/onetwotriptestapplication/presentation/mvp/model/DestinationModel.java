package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model;

/**
 * Class that represents destination in the presentation layer.
 */

public class DestinationModel {

    private final int destinationId;

    public DestinationModel (int destinationId) {
        this.destinationId = destinationId;
    }

    private String hotelName;
    private int amountOfOptions;
    private int price;

    public String getHotelName() { return hotelName; }

    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public int getAmountOfOptions() { return amountOfOptions; }

    public void setAmountOfOptions(int amountOfOptions) { this.amountOfOptions = amountOfOptions; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

}