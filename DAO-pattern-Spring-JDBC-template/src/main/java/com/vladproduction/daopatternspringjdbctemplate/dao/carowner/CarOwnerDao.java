package com.vladproduction.daopatternspringjdbctemplate.dao.carowner;

import com.vladproduction.daopatternspringjdbctemplate.models.Car;
import com.vladproduction.daopatternspringjdbctemplate.models.Owner;

import java.sql.SQLException;
import java.util.List;

public interface CarOwnerDao {

    int assignCarToOwner(int carId, int ownerId) throws SQLException;
    List<Car> getCarsForOwnerId(int ownerId) throws SQLException;
    Owner getOwnerForCarId(int carId) throws SQLException;
}
