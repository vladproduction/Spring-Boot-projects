package com.vladproduction.carshearing.dao;

import com.vladproduction.carshearing.model.Owner;

import java.sql.SQLException;
import java.util.List;

public interface OwnerDao {

    int addOwner(Owner owner) throws SQLException;
    Owner getOwnerById(int id) throws SQLException;
    List<Owner> getAllOwners() throws SQLException;
    int updateOwnerById(int id, Owner candidate)throws SQLException;
    int removeOwnerById(int id) throws SQLException;

}
