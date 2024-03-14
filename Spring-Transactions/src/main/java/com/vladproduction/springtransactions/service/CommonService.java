package com.vladproduction.springtransactions.service;

import com.vladproduction.springtransactions.model.Customer;
import com.vladproduction.springtransactions.model.Order;
import com.vladproduction.springtransactions.repository.CustomerRepo;
import com.vladproduction.springtransactions.repository.OrderRepo;
import org.springframework.stereotype.Service;

/**
 * Created by vladproduction on 14-Mar-24
 */
@Service
public class CommonService {

    private CustomerRepo customerRepo;
    private OrderRepo orderRepo;

    public CommonService(CustomerRepo customerRepo, OrderRepo orderRepo) {
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
    }

    public void save(Customer customer, Order order){
        customerRepo.saveCustomer(customer);
        orderRepo.saveOrder(order);
        String s = null;
        s.hashCode();
    }


}
