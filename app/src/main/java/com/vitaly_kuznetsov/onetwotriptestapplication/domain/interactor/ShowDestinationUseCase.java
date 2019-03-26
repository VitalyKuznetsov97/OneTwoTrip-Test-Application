package com.vitaly_kuznetsov.onetwotriptestapplication.domain.interactor;

import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Destination;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Flight;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.entity.Hotel;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.executor.ExecutionThread;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.executor.PostExecutionThread;
import com.vitaly_kuznetsov.onetwotriptestapplication.domain.repository.Repository;

import java.util.ArrayList;

import io.reactivex.Observable;

public class ShowDestinationUseCase extends UseCase<ArrayList<Destination>, Void>{

    private Repository repository;

    public ShowDestinationUseCase(Repository repository, ExecutionThread threadExecutor,
                                  PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.repository = repository;
    }

    @Override
    Observable<ArrayList<Destination>> buildUseCaseObservable(Void aVoid) {
        return Observable.
    }

    private void getDestinations() throws Exception{
        repository.init(this.executionThread.getScheduler(), this.postExecutionThread.getScheduler());
        ArrayList<Hotel> hotels = repository.getHotelsList();
        ArrayList<Flight> flights = repository.getFlightsList();
        ArrayList<Destination> destinations = new ArrayList<>();

        for (Hotel hotel : hotels){
            Destination destination = new Destination();
            destination.setHotel(hotel);
            for (int flightId : hotel.getFlights()){
                boolean flag = true;
                int i = 0;
                do {
                    if (i == hotel.getFlights().size()) flag = false;
                    else if (flights.get(i).getId() == flightId)
                        destination.getFlights().add(flights.get(i));
                    else i++;
                } while (flag);
            }
        }
    }
}
