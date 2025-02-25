package com.vladproduction.effectiveprototype.processor;

import com.vladproduction.effectiveprototype.model.Order;
import org.springframework.context.ApplicationContext;

/**
 * Extended implementation with custom behavior
 * */
public class RushOrderProcessor extends StandardOrderProcessor {

    public RushOrderProcessor(ApplicationContext context) {
        super(context);
    }

    @Override
    public Order createNewOrder() {
        // Get prototype bean but enhance it for rush orders
        Order rushOrder = super.createNewOrder();
        rushOrder.setStatus("RUSH_NEW");
        return rushOrder;
    }

    @Override
    public void processOrder(Order order) {
        // Custom processing for rush orders
        order.setStatus("RUSH_PROCESSING");
        // ... expedited processing steps
        order.setStatus("RUSH_COMPLETED");
    }


}
