package com.vladproduction.daopatternspringjdbctemplate.dao.carowner;

import com.vladproduction.daopatternspringjdbctemplate.models.Car;
import com.vladproduction.daopatternspringjdbctemplate.models.Owner;

import java.sql.SQLException;
import java.util.List;

public interface CarOwnerDao {

    int assignCarToOwner(int carId, int ownerId) throws SQLException;
    List<Car> getCarsForOwnerId(int ownerId) throws SQLException;
    Owner getOwnerForCarId(int carId) throws SQLException;
    int updateCarForOwnerById(int carId, int ownerId) throws SQLException;
    int deleteCarForOwnerById(int ownerId) throws SQLException;

    //SELECT c.* FROM car_owner co INNER JOIN car c ON co.car_id = c.id WHERE co.owner_id = 4;


}
