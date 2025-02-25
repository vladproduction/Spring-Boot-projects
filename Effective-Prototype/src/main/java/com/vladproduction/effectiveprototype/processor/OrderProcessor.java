package com.vladproduction.effectiveprototype.processor;

import com.vladproduction.effectiveprototype.model.Order;

/**
 * Core interface - not modified
 * */

public interface OrderProcessor {

    Order createNewOrder();

    void processOrder(Order order);


}
