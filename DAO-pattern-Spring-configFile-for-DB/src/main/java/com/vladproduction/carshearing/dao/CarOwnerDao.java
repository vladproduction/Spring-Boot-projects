package com.vladproduction.carshearing.dao;

import com.vladproduction.carshearing.model.Car;
import com.vladproduction.carshearing.model.Owner;

import java.sql.SQLException;
import java.util.List;

public interface CarOwnerDao {

    int assignCarToOwner(int carId, int ownerId) throws SQLException;
    List<Car> getCarsForOwnerId(int ownerId) throws SQLException;
    Owner getOwnerForCarId(int carId) throws SQLException;
}
