package com.vladproduction.daopatternspringjdbctemplate.dao.car;

import com.vladproduction.daopatternspringjdbctemplate.models.Car;
import com.vladproduction.daopatternspringjdbctemplate.rowmappers.CarRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("car")
public class CarDaoJdbcTemplateImpl implements CarDao{

    private JdbcTemplate jdbcTemplate;

    public CarDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addCar(Car car) throws SQLException {
        return jdbcTemplate.update("insert into car (brand, model, year) values (?, ?, ?)",
                car.getBrand(), car.getModel(), car.getYear());
    }

    @Override
    public Car getCarById(int id){
        //if fields are totally same as in DB
//      return jdbcTemplate.queryForObject("select * from car where id = ?", new Object[] {id}, Car.class);
        return jdbcTemplate.queryForObject("select * from car where id = ?", new Object[] {id}, new CarRowMapper());

    }

    @Override
    public List<Car> getAllCars(){
        return jdbcTemplate.query("select * from car", new CarRowMapper());
    }

    @Override
    public int updateCarById(int id, Car candidate) throws SQLException {
        return jdbcTemplate.update("update car set brand = ?, model = ?, year = ? where id = ?", candidate.getBrand(),
                candidate.getModel(), candidate.getYear(), id);

    }

    @Override
    public int removeCarById(int id) throws SQLException {
        return jdbcTemplate.update("delete from car where id=?", id);
    }
}
