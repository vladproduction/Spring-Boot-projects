package com.vladproduction.logginglevelsspring.service;

import com.vladproduction.logginglevelsspring.model.Order;
import org.springframework.stereotype.Service;

/**
 * Created by vladproduction on 13-Mar-24
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder(Order order) {
        Order savedOrder = new Order();
        savedOrder.setId(order.getId());
        savedOrder.setCustomerName(order.getCustomerName());
        savedOrder.setTotalPrice(order.getTotalPrice());
        return savedOrder;
    }


}
