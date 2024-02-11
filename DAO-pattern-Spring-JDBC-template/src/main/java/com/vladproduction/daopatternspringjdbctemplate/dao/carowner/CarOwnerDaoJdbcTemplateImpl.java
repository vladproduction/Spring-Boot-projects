package com.vladproduction.daopatternspringjdbctemplate.dao.carowner;


import com.vladproduction.daopatternspringjdbctemplate.models.Car;
import com.vladproduction.daopatternspringjdbctemplate.models.Owner;
import com.vladproduction.daopatternspringjdbctemplate.rowmappers.CarRowMapper;
import com.vladproduction.daopatternspringjdbctemplate.rowmappers.OwnerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("carOwner")
public class CarOwnerDaoJdbcTemplateImpl implements CarOwnerDao {

    private JdbcTemplate jdbcTemplate;

    public CarOwnerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int assignCarToOwner(int carId, int ownerId) throws SQLException {
        String sql = "INSERT INTO car_owner (car_id, owner_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, carId, ownerId);
    }

    @Override
    public List<Car> getCarsForOwnerId(int ownerId) throws SQLException {
        String sql2 = "SELECT c.* FROM car_owner co INNER JOIN car c ON co.car_id = c.id WHERE co.owner_id = ?";
        String sql = "SELECT c.* FROM car c JOIN car_owner co ON c.id = co.car_id WHERE co.owner_id = ?";
        return jdbcTemplate.query(sql2, new Object[] {ownerId}, new CarRowMapper()); //todo query(), or queryForList()???
    }

    @Override
    public Owner getOwnerForCarId(int carId) throws SQLException {
        String sql = "SELECT o.name, o.surname, o.phone FROM owner o JOIN car_owner co ON o.id = co.owner_id WHERE co.car_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {carId}, new OwnerRowMapper());
    }

    @Override
    public int updateCarForOwnerById(int carId, int ownerId) throws SQLException {
        String sql = "UPDATE car_owner SET car_id = ? WHERE owner_id = ?";
        return jdbcTemplate.update(sql, new Object[]{carId, ownerId});
    }

    @Override
    public int deleteCarForOwnerById(int ownerId) throws SQLException {
        String sql = "DELETE FROM car_owner WHERE owner_id = ?";
        return jdbcTemplate.update(sql, ownerId);
    }
}
