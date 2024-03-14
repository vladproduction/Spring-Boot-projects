package com.vladproduction.springtransactions.controller;

import com.vladproduction.springtransactions.model.Customer;
import com.vladproduction.springtransactions.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladproduction on 14-Mar-24
 */

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public void createCustomer(){
        Customer customer = new Customer();
        customer.setCustomerName("Tom" + System.currentTimeMillis());
        customerService.saveCustomer(customer);
    }
}
