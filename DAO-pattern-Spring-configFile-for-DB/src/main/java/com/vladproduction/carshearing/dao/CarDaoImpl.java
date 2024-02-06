package com.vladproduction.carshearing.dao;

import com.vladproduction.carshearing.datasource.DataSourceManager;
import com.vladproduction.carshearing.model.Car;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("carMySql")
public class CarDaoImpl implements CarDao {

    private DataSourceManager sourceManager;

    public CarDaoImpl(DataSourceManager sourceManager) {
        this.sourceManager = sourceManager;
    }

    @Override
    public int addCar(Car car) throws SQLException {
        String sql = "insert into car (brand, model, year) values (?, ?, ?)";
        try(Connection c = sourceManager.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, car.getBrand());
            ps.setString(2, car.getModel());
            ps.setInt(3, car.getYear());
            int executedUpdate = ps.executeUpdate();
            if(executedUpdate > 0){
                System.out.println("Entity(Car) added successfully!");
            }else {
                System.out.println("No entity(Car) been added.");
            }
            return executedUpdate;
        }

    }

    @Override
    public Car getCarById(int id) throws SQLException {
        String sql = "select * from car where id = ?";
        try(Connection c = sourceManager.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                Car car = new Car();
//                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getInt("year"));
                return car;
            }else {
                System.out.println("No entity(Car) found with the given ID.");
                return null;
            }
        }
    }

    @Override
    public List<Car> getAllCars() throws SQLException {
        String sql = "select * from car";
        try(Connection c = sourceManager.getConnection()){
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Car> cars = new ArrayList<>();
            while (resultSet.next()){
                Car car = new Car();
//                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setYear(resultSet.getInt("year"));
                cars.add(car);
            }
            return cars;
        }
    }

    @Override
    public int updateCarById(int id, Car candidate) throws SQLException {
        String sql = "update car set brand = ?, model = ?, year = ? where id = ?";
        try (Connection c = sourceManager.getConnection()) {
            PreparedStatement ps = c.prepareStatement(sql);
            Car carById = getCarById(id);
            carById.setBrand(candidate.getBrand());
            carById.setModel(candidate.getModel());
            carById.setYear(candidate.getYear());
            ps.setString(1, carById.getBrand());
            ps.setString(2, carById.getModel());
            ps.setInt(3, carById.getYear());
//            ps.setInt(4, getCarById(id).getId());
            int executedUpdate = ps.executeUpdate();
            if(executedUpdate > 0){
                System.out.println("Entity(Car) updated successfully!");
            }else {
                System.out.println("No entity(Car) found with the given ID.");
            }
            return executedUpdate;
        }
    }

    @Override
    public int removeCarById(int id) throws SQLException {
        String sql = "delete from car where id=?";
        try(Connection c = sourceManager.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            int executedUpdate = ps.executeUpdate();
            if(executedUpdate > 0){
                System.out.println("Entity(Car) removed successfully!");
            }else {
                System.out.println("No entity(Car) found with the given ID.");
            }
            return executedUpdate;
        }
    }
}
