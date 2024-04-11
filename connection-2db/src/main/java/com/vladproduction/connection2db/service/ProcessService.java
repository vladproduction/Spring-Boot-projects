package com.vladproduction.connection2db.service;

import com.vladproduction.connection2db.entity.car.Car;
import com.vladproduction.connection2db.entity.bike.Bike;
import com.vladproduction.connection2db.repository.BikeRepository;
import com.vladproduction.connection2db.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vladproduction on 10-Apr-24
 */

@Service
//@Transactional
public class ProcessService {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private CarRepository carRepository;

    //creating and save to separate databases consequently:
    public void process(){

        Bike bike = new Bike();
        bike.setBike_model("Java");
        bike.setBike_color("red");
        bike.setBike_price(1500.0);
        bikeRepository.save(bike);
        System.out.println("========BIKE SAVED==========");

        Car car = new Car();
        car.setCar_model("BMW");
        car.setCar_color("white");
        car.setCar_price(50000.0);
        carRepository.save(car);
        System.out.println("========CAR SAVED==========");

    }
}
