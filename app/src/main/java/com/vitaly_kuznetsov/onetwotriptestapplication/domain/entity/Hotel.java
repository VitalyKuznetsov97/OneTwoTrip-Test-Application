package com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity;

import java.util.ArrayList;

public class Hotel implements Entity{

    private int id;
    private ArrayList<Integer> flights = new ArrayList<>();
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

    public ArrayList<Integer> getFlights() {
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

    public void setFlights(ArrayList<Integer> flights) {
        this.flights = flights;
    }
}
