package com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity;

public class Flight implements Entity{

    private int id;
    private int companyId;
    private String departure;
    private String arrival;
    private int price;


    // Getter Methods

    public int getId() {
        return id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public int getPrice() {
        return price;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
