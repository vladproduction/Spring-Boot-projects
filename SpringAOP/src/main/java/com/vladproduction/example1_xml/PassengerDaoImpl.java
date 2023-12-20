package com.vladproduction.example1_xml;

import java.util.HashMap;
import java.util.Map;

public class PassengerDaoImpl implements PassengerDao {

    private static Map<Integer, Passenger> passengersMap = new HashMap<>();
    @Override
    public Passenger getPassenger(int id) {

        if(null != passengersMap.get(id)){  //???
            return passengersMap.get(id);
        }

        Passenger passenger = new Passenger(id);
        passengersMap.put(id, passenger);
        return passenger;
    }
}
