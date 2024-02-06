package com.vladproduction.carshearing.service;

import com.vladproduction.carshearing.dao.CarDao;
import com.vladproduction.carshearing.model.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CarService {

    @Qualifier("carMySql")
    private CarDao carDao;

    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public int addCar(Car car) throws SQLException{
        return this.carDao.addCar(car);
    }

    public Car getCarById(int id) throws SQLException{
        return this.carDao.getCarById(id);
    }

    public List<Car> getAllCars() throws SQLException{
        return this.carDao.getAllCars();
    }

    public int updateCarById(int id, Car candidate) throws SQLException{
        return this.carDao.updateCarById(id, candidate);
    }

    public int removeCarById(int id) throws SQLException {
        return this.carDao.removeCarById(id);
    }
}
