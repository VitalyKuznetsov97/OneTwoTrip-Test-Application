package com.vitaly_kuznetsov.onetwotriptestapplication.presentation.mvp.model;


/**
 * Class that represents single hotelFilter in the presentation layer.
 */
public class HotelFilterModel {

    private final int hotelId;

    public HotelFilterModel(int hotelId) { this.hotelId = hotelId; }

    private String hotelName;
    private boolean checked;

    public String getHotelName() { return hotelName; }

    public void setHotelName(String hotelName) { this.hotelName = hotelName; }

    public boolean isChecked() { return checked; }

    public void setChecked(boolean checked) { this.checked = checked; }
}