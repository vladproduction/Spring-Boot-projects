package com.vladproduction.daopatternspringjdbctemplate.dao.owner;

import com.vladproduction.daopatternspringjdbctemplate.models.Owner;
import com.vladproduction.daopatternspringjdbctemplate.rowmappers.OwnerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("owner")
public class OwnerDaoJdbcTemplateImpl implements OwnerDao {

    private JdbcTemplate jdbcTemplate;

    public OwnerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addOwner(Owner owner) throws SQLException {
        String sql = "insert into owner (name, surname, phone) values (?, ?, ?)";
        return jdbcTemplate.update(sql, owner.getName(), owner.getSurname(), owner.getPhone());

    }

    @Override
    public Owner getOwnerById(int id) throws SQLException {
        String sql = "select * from owner where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {id}, new OwnerRowMapper());

    }

    @Override
    public List<Owner> getAllOwners() throws SQLException {
        String sql = "select * from owner";
        return jdbcTemplate.query(sql, new OwnerRowMapper());
    }

    @Override
    public int updateOwnerById(int id, Owner candidate) throws SQLException {
        String sql = "update owner set name = ?, surname = ?, phone = ? where id = ?";
        return jdbcTemplate.update(sql, candidate.getName(), candidate.getSurname(), candidate.getPhone());
    }

    @Override
    public int removeOwnerById(int id) throws SQLException {
        String sql = "delete from owner where id=?";
        return jdbcTemplate.update(sql, id);
    }
}
