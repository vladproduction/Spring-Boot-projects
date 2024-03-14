package com.vladproduction.springtransactions.controller;

import com.vladproduction.springtransactions.model.Customer;
import com.vladproduction.springtransactions.model.Order;
import com.vladproduction.springtransactions.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladproduction on 14-Mar-24
 */

@RestController
@RequestMapping("/api/common")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @GetMapping
    public void createSave(){

        Customer customer = new Customer();
        customer.setCustomerName("Test" + System.currentTimeMillis());
        customer.setValidAccount(true);

        Order order = new Order();
        order.setOrderName("Test Order # " + System.currentTimeMillis());
        order.setTotalPrice(500.2);

        commonService.save(customer, order);

    }
}
