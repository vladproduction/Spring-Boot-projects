package com.vladproduction.springtransactions.service;

import com.vladproduction.springtransactions.model.Customer;
import com.vladproduction.springtransactions.model.Order;
import com.vladproduction.springtransactions.repository.CustomerRepo;
import com.vladproduction.springtransactions.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vladproduction on 14-Mar-24
 */

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public void saveOrder(Order order) {

        orderRepo.saveOrder(order);
    }

}
