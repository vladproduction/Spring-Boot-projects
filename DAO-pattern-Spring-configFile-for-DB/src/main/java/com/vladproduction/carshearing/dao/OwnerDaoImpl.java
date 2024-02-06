package com.vladproduction.carshearing.dao;

import com.vladproduction.carshearing.datasource.DataSourceManager;
import com.vladproduction.carshearing.model.Owner;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("ownerMySql")
public class OwnerDaoImpl implements OwnerDao {

    private DataSourceManager sourceManager;

    public OwnerDaoImpl(DataSourceManager sourceManager) {
        this.sourceManager = sourceManager;
    }

    @Override
    public int addOwner(Owner owner) throws SQLException {
        String sql = "insert into owner (name, surname, phone) values (?, ?, ?)";
        try(Connection c = sourceManager.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, owner.getName());
            ps.setString(2, owner.getSurname());
            ps.setString(3, owner.getPhone());
            int executedUpdate = ps.executeUpdate();
            if(executedUpdate > 0){
                System.out.println("Entity(Owner) added successfully!");
            }else {
                System.out.println("No entity(Owner) been added.");
            }
            return executedUpdate;
        }
    }

    @Override
    public Owner getOwnerById(int id) throws SQLException {
        String sql = "select * from owner where id = ?";
        try(Connection c = sourceManager.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                Owner owner = new Owner();
//                owner.setId(resultSet.getInt("id"));
                owner.setName(resultSet.getString("name"));
                owner.setSurname(resultSet.getString("surname"));
                owner.setPhone(resultSet.getString("phone"));
                return owner;
            }else {
                return null;
            }
        }
    }

    @Override
    public List<Owner> getAllOwners() throws SQLException {
        String sql = "select * from owner";
        try(Connection c = sourceManager.getConnection()){
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Owner> owners = new ArrayList<>();
            while (resultSet.next()){
                Owner owner = new Owner();
//                owner.setId(resultSet.getInt("id"));
                owner.setName(resultSet.getString("name"));
                owner.setSurname(resultSet.getString("surname"));
                owner.setPhone(resultSet.getString("phone"));
                owners.add(owner);
            }
            return owners;
        }
    }

    @Override
    public int updateOwnerById(int id, Owner candidate) throws SQLException {
        String sql = "update owner set name = ?, surname = ?, phone = ? where id = ?";
        try(Connection c = sourceManager.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            Owner ownerById = getOwnerById(id);
            ownerById.setName(candidate.getName());
            ownerById.setSurname(candidate.getSurname());
            ownerById.setPhone(candidate.getPhone());
            ps.setString(1, ownerById.getName());
            ps.setString(2, ownerById.getSurname());
            ps.setString(3, ownerById.getPhone());
//            ps.setInt(4, getOwnerById(id).getId());
            int executedUpdate = ps.executeUpdate();
            if(executedUpdate > 0){
                System.out.println("Entity(Owner) updated successfully!");
            }else {
                System.out.println("No entity(Owner) found with the given ID.");
            }
            return executedUpdate;
        }
    }

    @Override
    public int removeOwnerById(int id) throws SQLException {
        String sql = "delete from owner where id=?";
        try(Connection c = sourceManager.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            int executedUpdate = ps.executeUpdate();
            if(executedUpdate > 0){
                System.out.println("Entity(Owner) removed successfully!");
            }else {
                System.out.println("No entity(Owner) found with the given ID.");
            }
            return executedUpdate;
        }
    }
}
