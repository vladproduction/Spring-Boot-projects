package com.vladproduction.carshearing.dao;

import com.vladproduction.carshearing.datasource.DataSourceManager;
import com.vladproduction.carshearing.model.Car;
import com.vladproduction.carshearing.model.Owner;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository("carOwnerMySql")
public class CarOwnerDaoImpl implements CarOwnerDao {

    private DataSourceManager sourceManager;

    public CarOwnerDaoImpl(DataSourceManager sourceManager) {
        this.sourceManager = sourceManager;
    }

    @Override
    public int assignCarToOwner(int carId, int ownerId) throws SQLException {
        String sql = "INSERT INTO car_owner (car_id, owner_id) VALUES (?, ?)";
        try (Connection c = sourceManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, carId);
            ps.setInt(2, ownerId);
            int executedUpdate = ps.executeUpdate();
            if (executedUpdate > 0) {
                System.out.println("Car assigned to Owner successfully!");
            } else if (executedUpdate == 0) {
                throw new SQLException("Failed to assign car to owner");
            }
            return executedUpdate;
        }


    }

    @Override
    public List<Car> getCarsForOwnerId(int ownerId) throws SQLException {
        String sql = "SELECT c.* FROM car c JOIN car_owner co ON c.id = co.car_id WHERE co.owner_id = ?";
        try (Connection c = sourceManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, ownerId);

            ResultSet resultSet = ps.executeQuery();
            List<Car> cars = new ArrayList<>();
            while (resultSet.next()) {
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
    public Owner getOwnerForCarId(int carId) throws SQLException {
        String sql = "SELECT o.name, o.surname, o.phone FROM owner o JOIN car_owner co ON o.id = co.owner_id WHERE co.car_id = ?";
        try (Connection c = sourceManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, carId);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                Owner owner = new Owner();
                owner.setName(resultSet.getString("name"));
                owner.setSurname(resultSet.getString("surname"));
                owner.setPhone(resultSet.getString("phone"));
                return owner;
            } else {
                return null;
            }
        }
    }
}
