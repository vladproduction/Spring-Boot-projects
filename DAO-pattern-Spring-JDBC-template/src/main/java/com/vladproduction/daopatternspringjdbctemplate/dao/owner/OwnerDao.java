package com.vladproduction.daopatternspringjdbctemplate.dao.owner;

import com.vladproduction.daopatternspringjdbctemplate.models.Owner;

import java.sql.SQLException;
import java.util.List;

public interface OwnerDao {

    int addOwner(Owner owner) throws SQLException;
    Owner getOwnerById(int id) throws SQLException;
    List<Owner> getAllOwners() throws SQLException;
    int updateOwnerById(int id, Owner candidate)throws SQLException;
    int removeOwnerById(int id) throws SQLException;

}
