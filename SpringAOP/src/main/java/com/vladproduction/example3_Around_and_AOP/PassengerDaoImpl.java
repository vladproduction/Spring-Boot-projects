package com.vladproduction.example3_Around_and_AOP;

import java.util.HashMap;
import java.util.Map;

public class PassengerDaoImpl  implements PassengerDao{//implements PassengerDao

    private static final Map<Integer, Passenger> passengersMap = new HashMap<>();

    @Override
    public  Passenger getPassenger(int id) { //final

        if(null != passengersMap.get(id)){
            return passengersMap.get(id);
        }

        Passenger passenger = new Passenger(id);
        passengersMap.put(id, passenger);
        return passenger;
    }
}
