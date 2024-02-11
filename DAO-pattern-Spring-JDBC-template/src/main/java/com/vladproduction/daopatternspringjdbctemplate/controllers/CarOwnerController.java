package com.vladproduction.daopatternspringjdbctemplate.controllers;

import com.vladproduction.daopatternspringjdbctemplate.models.Car;
import com.vladproduction.daopatternspringjdbctemplate.models.Owner;
import com.vladproduction.daopatternspringjdbctemplate.services.CarOwnerService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("api/car_shearing")
public class CarOwnerController {

    private final CarOwnerService carOwnerService;

    public CarOwnerController(CarOwnerService carOwnerService) {
        this.carOwnerService = carOwnerService;
    }

    @PostMapping("/assignCarToOwner/{carId}/{ownerId}")
    public int assignCarToOwner(@PathVariable int carId, @PathVariable int ownerId) throws SQLException {
        return this.carOwnerService.assignCarToOwner(carId, ownerId);
    }

    @GetMapping("/getCarsForOwnerId/{ownerId}")
    public List<Car> getCarsForOwnerId(@PathVariable int ownerId) throws SQLException {
        return this.carOwnerService.getCarsForOwnerId(ownerId);
    }

    @GetMapping("getOwnerForCarId/{carId}")
    public Owner getOwnerForCarId(@PathVariable int carId) throws SQLException {
        return this.carOwnerService.getOwnerForCarId(carId);
    }
    @PutMapping("updateCarForOwnerById/{carId}/{ownerId}")
    public int updateCarForOwnerById(@PathVariable int carId, @PathVariable int ownerId) throws SQLException {
        return carOwnerService.updateCarForOwnerById(carId, ownerId);
    }

    @DeleteMapping("deleteCarForOwnerById/{ownerId}")
    public int deleteCarForOwnerById(@PathVariable int ownerId) throws SQLException {
        return carOwnerService.deleteCarForOwnerById(ownerId);
    }
}
