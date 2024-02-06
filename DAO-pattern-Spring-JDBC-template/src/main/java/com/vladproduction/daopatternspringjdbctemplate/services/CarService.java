package com.vladproduction.daopatternspringjdbctemplate.services;

import com.vladproduction.daopatternspringjdbctemplate.dao.car.CarDao;
import com.vladproduction.daopatternspringjdbctemplate.models.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CarService {

    private CarDao carDaoJdbc;

    public CarService(@Qualifier("car") CarDao carDaoJdbc) {
        this.carDaoJdbc = carDaoJdbc;
    }

    public int addCar(Car car) throws SQLException{
        return carDaoJdbc.addCar(car);
    }

    public Car getCarById(int id) throws SQLException{
        return carDaoJdbc.getCarById(id);
    }

    public List<Car> getAllCars() throws SQLException{
        return carDaoJdbc.getAllCars();
    }

    public int updateCarById(int id, Car candidate) throws SQLException{
        return carDaoJdbc.updateCarById(id, candidate);
    }

    public int removeCarById(int id) throws SQLException {
        return carDaoJdbc.removeCarById(id);
    }
}
