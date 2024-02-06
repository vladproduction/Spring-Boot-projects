package com.vladproduction.carshearing.service;

import com.vladproduction.carshearing.dao.OwnerDao;
import com.vladproduction.carshearing.model.Owner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OwnerService {

    @Qualifier("ownerMySql")
    private OwnerDao ownerDao;


    public OwnerService(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    public int addOwner(Owner owner) throws SQLException{
        return this.ownerDao.addOwner(owner);
    }

    public Owner getOwnerById(int id) throws SQLException {
        return this.ownerDao.getOwnerById(id);
    }

    public List<Owner> getAllOwners() throws SQLException{
        return this.ownerDao.getAllOwners();
    }

    public int updateOwnerById(int id, Owner candidate) throws SQLException {
        return this.ownerDao.updateOwnerById(id, candidate);
    }

    public int removeOwnerById(int id) throws SQLException{
        return this.ownerDao.removeOwnerById(id);
    }

}
