package com.vladproduction.effectiveprototype;

import com.vladproduction.effectiveprototype.config.OrderProcessingConfig;
import com.vladproduction.effectiveprototype.model.Order;
import com.vladproduction.effectiveprototype.processor.OrderProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * performing of how this would be used in an application
 * */

@SpringBootApplication
public class EffectivePrototypeApplication {

    public static void main(String[] args) {
        //SpringApplication.run(EffectivePrototypeApplication.class, args);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(OrderProcessingConfig.class);

        // Get the processors
        OrderProcessor standardProcessor = context.getBean("standardOrderProcessor", OrderProcessor.class);
        OrderProcessor rushProcessor = context.getBean("rushOrderProcessor", OrderProcessor.class);

        // Create and process standard order
        Order standardOrder = standardProcessor.createNewOrder();
        standardOrder.addItem("Standard Item");
        standardProcessor.processOrder(standardOrder);

        // Create and process rush order
        Order rushOrder = rushProcessor.createNewOrder();
        rushOrder.addItem("Rush Item");
        rushProcessor.processOrder(rushOrder);

        // Output results
        System.out.println("Standard Order: " + standardOrder);
        System.out.println("Rush Order: " + rushOrder);

        // Multiple calls to get Order bean will create new instances
        Order order1 = context.getBean(Order.class);
        Order order2 = context.getBean(Order.class);
        System.out.println("Are orders the same instance? " + (order1 == order2));

        context.close();
    }

}
