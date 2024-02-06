package com.vladproduction.daopatternspringjdbctemplate.services;

import com.vladproduction.daopatternspringjdbctemplate.dao.owner.OwnerDao;
import com.vladproduction.daopatternspringjdbctemplate.models.Owner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OwnerService {

    private OwnerDao ownerDaoJdbc;

    public OwnerService(@Qualifier("owner") OwnerDao ownerDaoJdbc) {
        this.ownerDaoJdbc = ownerDaoJdbc;
    }

    public int addOwner(Owner owner) throws SQLException{
        return this.ownerDaoJdbc.addOwner(owner);
    }

    public Owner getOwnerById(int id) throws SQLException {
        return this.ownerDaoJdbc.getOwnerById(id);
    }

    public List<Owner> getAllOwners() throws SQLException{
        return this.ownerDaoJdbc.getAllOwners();
    }

    public int updateOwnerById(int id, Owner candidate) throws SQLException {
        return this.ownerDaoJdbc.updateOwnerById(id, candidate);
    }

    public int removeOwnerById(int id) throws SQLException{
        return this.ownerDaoJdbc.removeOwnerById(id);
    }

}
