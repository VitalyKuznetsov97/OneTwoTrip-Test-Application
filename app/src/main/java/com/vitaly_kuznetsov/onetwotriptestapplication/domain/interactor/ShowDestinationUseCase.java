package com.vitaly_kuznetsov.onetwotriptestapplication.domain.interactor;

import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Destination;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Entity;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Flight;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Hotel;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.executor.ExecutionThread;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.executor.PostExecutionThread;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.repository.Repository;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.exceptions.Exceptions;

public class ShowDestinationUseCase extends UseCase<ArrayList<Entity>, Void>{

    private Repository repository;

    public ShowDestinationUseCase(Repository repository, ExecutionThread threadExecutor,
                                  PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    Observable<ArrayList<Entity>> buildUseCaseObservable(Void aVoid) {
        return Observable.just("")
                .map(input -> {
                    try {
                        return getDestinations();
                    }
                    catch (Exception e){
                        repository.clear();
                        throw Exceptions.propagate(e);
                    }
                });
    }

    private ArrayList<Entity> getDestinations() throws Exception{
        repository.init();

        ArrayList<Hotel> hotels = repository.getHotelsList();
        ArrayList<Flight> flights = repository.getFlightsList();
        ArrayList<Entity> entities = new ArrayList<>();

        for (Hotel hotel : hotels){
            Destination destination = new Destination();
            destination.setHotel(hotel);
            for (int flightId : hotel.getFlights()){
                boolean flag = true;
                int i = 0;
                do {
                    if (i >= hotel.getFlights().get(hotel.getFlights().size() - 1)) flag = false;
                    else if (flights.get(i).getId() == flightId) {
                        destination.getFlights().add(flights.get(i));
                        flag = false;
                    }
                    else i++;
                } while (flag);
            }
            if (destination.getFlights().size() != 0) entities.add(destination);
        }

        return entities;
    }
}
