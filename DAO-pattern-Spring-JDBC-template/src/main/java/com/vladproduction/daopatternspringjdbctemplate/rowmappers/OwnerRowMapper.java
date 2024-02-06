package com.vladproduction.daopatternspringjdbctemplate.rowmappers;

import com.vladproduction.daopatternspringjdbctemplate.models.Owner;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnerRowMapper implements RowMapper<Owner> {
    @Override
    public Owner mapRow(ResultSet rs, int rowNum) throws SQLException {
        Owner owner = new Owner();
        owner.setName(rs.getString("name"));
        owner.setSurname(rs.getString("surname"));
        owner.setPhone(rs.getString("phone"));
        return owner;
    }
}
