package com.vladproduction.daopatternspringjdbctemplate.services;

import com.vladproduction.daopatternspringjdbctemplate.dao.carowner.CarOwnerDao;
import com.vladproduction.daopatternspringjdbctemplate.models.Car;
import com.vladproduction.daopatternspringjdbctemplate.models.Owner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CarOwnerService {

    private CarOwnerDao carOwnerDaoJdbc;

    public CarOwnerService(@Qualifier("carOwner")CarOwnerDao carOwnerDaoJdbc) {
        this.carOwnerDaoJdbc = carOwnerDaoJdbc;
    }

    public int assignCarToOwner(int carId, int ownerId) throws SQLException {
        return this.carOwnerDaoJdbc.assignCarToOwner(carId, ownerId);
    }

    public List<Car> getCarsForOwnerId(int ownerId) throws SQLException {
        return this.carOwnerDaoJdbc.getCarsForOwnerId(ownerId);
    }


    public Owner getOwnerForCarId(int carId) throws SQLException {
        return this.carOwnerDaoJdbc.getOwnerForCarId(carId);
    }
}
