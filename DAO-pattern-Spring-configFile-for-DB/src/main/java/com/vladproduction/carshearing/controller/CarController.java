package com.vladproduction.carshearing.controller;

import com.vladproduction.carshearing.model.Car;
import com.vladproduction.carshearing.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/car_shearing")
public class CarController {

    private final CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/add_car")
    public int addCar(@RequestParam String brand,
                       @RequestParam String model,
                       @RequestParam int year) throws SQLException{
        return carService.addCar(new Car(brand, model, year));
    }

    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable int id)throws SQLException{
        return carService.getCarById(id);
    }

    @GetMapping("/cars")
    public List<Car> getAllCars()throws SQLException{
        return carService.getAllCars();
    }

    @PutMapping("updateCarById/{id}")
    public int updateCarById(@PathVariable int id, @RequestBody Car candidate) throws SQLException {
        return carService.updateCarById(id, candidate);
    }

    @DeleteMapping("/remove_car/{id}")
    public int removeCarById(@PathVariable int id) throws SQLException {
        return carService.removeCarById(id);
    }
}
