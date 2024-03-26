package com.vladproduction.transactionspringbootapp.controller;

import com.vladproduction.transactionspringbootapp.dto.OrderAck;
import com.vladproduction.transactionspringbootapp.dto.OrderRequest;
import com.vladproduction.transactionspringbootapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladproduction on 26-Mar-24
 */

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public OrderAck placeOrder(@RequestBody OrderRequest orderRequest){
        return orderService.placingOrder(orderRequest);

    }
}
