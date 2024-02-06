package com.vladproduction.carshearing.dao;

import com.vladproduction.carshearing.model.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarDao {

    int addCar(Car car) throws SQLException;
    Car getCarById(int id) throws SQLException;
    List<Car> getAllCars() throws SQLException;
    int updateCarById(int id, Car candidate) throws SQLException;
    int removeCarById(int id) throws SQLException;

}
