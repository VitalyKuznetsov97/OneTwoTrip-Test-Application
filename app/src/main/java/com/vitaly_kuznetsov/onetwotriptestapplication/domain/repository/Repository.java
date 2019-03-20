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
    boolean init(Scheduler executionScheduler, Scheduler postExecutionScheduler);
    ArrayList<Hotel> getHotelsList();
    ArrayList<Flight> getFlightsList();
    ArrayList<Company> getCompaniesList();
}
