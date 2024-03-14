package com.vladproduction.springtransactions.controller;

import com.vladproduction.springtransactions.model.Order;
import com.vladproduction.springtransactions.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladproduction on 14-Mar-24
 */

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public void createOrder(){
        Order order = new Order();
        order.setOrderName("Order #:" + System.currentTimeMillis());
        order.setTotalPrice(120.5);
        orderService.saveOrder(order);
    }
}
