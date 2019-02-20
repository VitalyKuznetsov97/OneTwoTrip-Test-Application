package com.vitaly_kuznetsov.onetwotriptestapplication.data.server_rest_api.post_models;

import java.util.ArrayList;

public class HotelsModel{

    private int id;
    private ArrayList<FlightsModel> flights = new ArrayList<>();
    private String name;
    private int price;


    // Getter Methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<FlightsModel> getFlights() {
        return flights;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFlights(ArrayList<FlightsModel> flights) {
        this.flights = flights;
    }
}
