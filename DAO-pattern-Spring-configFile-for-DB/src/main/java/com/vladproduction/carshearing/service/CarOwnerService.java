package com.vladproduction.carshearing.service;

import com.vladproduction.carshearing.dao.CarOwnerDao;
import com.vladproduction.carshearing.model.Car;
import com.vladproduction.carshearing.model.Owner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CarOwnerService {

    @Qualifier("carOwnerMySql")
    private CarOwnerDao carOwnerDao;

    public CarOwnerService(CarOwnerDao carOwnerDao) {
        this.carOwnerDao = carOwnerDao;
    }

    public int assignCarToOwner(int carId, int ownerId) throws SQLException {
        return this.carOwnerDao.assignCarToOwner(carId, ownerId);
    }

    public List<Car> getCarsForOwnerId(int ownerId) throws SQLException {
        return this.carOwnerDao.getCarsForOwnerId(ownerId);
    }


    public Owner getOwnerForCarId(int carId) throws SQLException {
        return this.carOwnerDao.getOwnerForCarId(carId);
    }
}
