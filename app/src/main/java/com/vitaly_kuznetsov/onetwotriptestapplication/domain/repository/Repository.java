package com.vitaly_kuznetsov.onetwotriptestapplication.domain.repository;

import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Company;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Entity;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Flight;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Hotel;

import java.util.ArrayList;

import io.reactivex.Scheduler;

/**
 * Interface that represents a Repository for getting {@link Entity} related data.
 */
public interface Repository {

    void init() throws Exception;
    void clear();

    ArrayList<Hotel> getHotelsList() throws Exception;
    ArrayList<Flight> getFlightsList() throws Exception;
    ArrayList<Company> getCompaniesList() throws Exception;
}
