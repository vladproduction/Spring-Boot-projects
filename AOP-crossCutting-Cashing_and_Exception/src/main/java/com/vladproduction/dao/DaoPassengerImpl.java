package com.vladproduction.dao;

import com.vladproduction.exceptions.CountryDoesNotExistException;
import com.vladproduction.management.Passenger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DaoPassengerImpl implements Dao {

    private static Map<Integer, Passenger> passengersMap = new HashMap<>();

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public static Map<Integer, Passenger> getPassengersMap() {
        return passengersMap;
    }

    private RowMapper<Passenger> rowMapper = (resultSet, rowNum) ->{
        Passenger passenger = new Passenger();
        passenger.setName(resultSet.getString("name"));
        passenger.setCountry(resultSet.getString("country"));
        return passenger;
    };

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    private Passenger getById(int id){
        String sql = "select * from passengers where id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);

    }
    @Override
    public Passenger getPassenger(int id) {
        if(passengersMap.get(id) != null){
            passengersMap.get(id);
            System.out.println("PASSENGER GET FROM THE MAP NOW");
        }
        Passenger passenger = getById(id);
        return passenger;
    }

    @Override
    public void insert(Passenger passenger) {
        if(!Arrays.asList(Locale.getISOCountries()).contains(passenger.getCountry())){
            throw new CountryDoesNotExistException(passenger.getCountry());
        }
        String sql = "insert into passengers (NAME, COUNTRY) values (?, ?)";
        jdbcTemplate.update(sql, new Object[]{
                passenger.getName(),
                passenger.getCountry()
        });

    }
}
