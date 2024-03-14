package com.vladproduction.springtransactions.repository;

import com.vladproduction.springtransactions.model.Customer;
import com.vladproduction.springtransactions.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by vladproduction on 14-Mar-24
 */

@Repository
public class OrderRepo {

    @Autowired
    private DataSource dataSource;

    public void saveOrder(Order order){
        String sql = "insert into orders (orderName, totalPrice) values (?, ?)";
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, order.getOrderName());
            ps.setDouble(2, order.getTotalPrice());
            ps.execute();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
