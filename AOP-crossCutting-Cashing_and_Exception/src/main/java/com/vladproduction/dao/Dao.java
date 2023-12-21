package com.vladproduction.dao;

import com.vladproduction.management.Passenger;

public interface Dao {

    Passenger getPassenger(int id);
    void insert(Passenger passenger);
}
