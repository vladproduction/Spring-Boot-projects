package com.vladproduction.effectiveprototype.config;

import com.vladproduction.effectiveprototype.model.Order;
import com.vladproduction.effectiveprototype.processor.OrderProcessor;
import com.vladproduction.effectiveprototype.processor.RushOrderProcessor;
import com.vladproduction.effectiveprototype.processor.StandardOrderProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Configuration class demonstrating effective use of Spring scopes
 * */
@Configuration
public class OrderProcessingConfig {

    /**
     * Creates a prototype-scoped Order bean.
     * Each injection point or getBean() call will receive a new instance.
     */
    @Bean
    @Scope("prototype")
    public Order order() {
        return new Order(UUID.randomUUID().toString(), LocalDateTime.now());
    }

    /**
     * Creates a singleton OrderProcessor that works with prototype Order objects.
     */
    @Bean
    public OrderProcessor standardOrderProcessor(ApplicationContext context) {
        return new StandardOrderProcessor(context);
    }

    /**
     * Creates a custom OrderProcessor that extends the standard one
     * but with special handling for rush orders.
     */
    @Bean
    public OrderProcessor rushOrderProcessor(ApplicationContext context) {
        return new RushOrderProcessor(context);
    }

}
