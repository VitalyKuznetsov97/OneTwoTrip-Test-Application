package com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity;

import java.util.ArrayList;

public class Destination implements Entity {

    private Hotel hotel;
    private ArrayList<Flight> flights = new ArrayList<>();

    public int getLowestPrice(){
        int result = flights.get(0).getPrice();
        for (Flight flight : flights)
            if (flight.getPrice() < result) result = flight.getPrice();
        return result + hotel.getPrice();
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
}
