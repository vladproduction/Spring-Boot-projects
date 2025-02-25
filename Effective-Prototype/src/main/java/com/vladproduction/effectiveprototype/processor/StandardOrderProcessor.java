package com.vladproduction.effectiveprototype.processor;

import com.vladproduction.effectiveprototype.model.Order;
import org.springframework.context.ApplicationContext;

/**
 * Standard implementation
 * */

public class StandardOrderProcessor implements OrderProcessor {

    private final ApplicationContext context;

    public StandardOrderProcessor(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Order createNewOrder() {
        // Get a new prototype Order instance each time
        Order newOrder = context.getBean(Order.class);
        return newOrder;
    }

    @Override
    public void processOrder(Order order) {
        // Standard processing logic
        order.setStatus("PROCESSING");
        // ... other processing steps
        order.setStatus("COMPLETED");
    }

}
