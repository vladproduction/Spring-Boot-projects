package com.vladproduction.logginglevelsspring.controller;

import com.vladproduction.logginglevelsspring.model.Employee;
import com.vladproduction.logginglevelsspring.model.Order;
import com.vladproduction.logginglevelsspring.model.Product;
import com.vladproduction.logginglevelsspring.service.OrderService;
import com.vladproduction.logginglevelsspring.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vladproduction on 12-Mar-24
 */

@RestController
public class MyController {

    private final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;



    ////////////////////////    Basic Logging:   ////////////////////////////
    @GetMapping("/hello")
    public String sayHello(){

        logger.info("Get request received for '/hello' - info");

        //work if permission is 'debug' (logging.level setter for controller in application.properties)
        logger.debug("Get request received for '/hello' - debug");

        return "Hello World!";
    }



    ////////////////////////    Logging with parameters:   ////////////////////////////
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        logger.info("@PostMapping(/employee) creating started");
        logger.debug("Creating Employee with firstName: {}, lastName: {}, age: {}, hiringDate: {}, role: {}",
                employee.getFirstName(), employee.getLastName(), employee.getAge(), employee.getHiringDate(), employee.getRole());
        Employee emp = new Employee();
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setAge(employee.getAge());
        emp.setHiringDate(employee.getHiringDate());
        emp.setRole(employee.getRole());
        logger.info("@PostMapping(/employee) creating finished");
        return emp;
    }


    ////////////////////////    Conditional Logging:   ////////////////////////////
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product != null) {
            logger.info("Product with ID {} found", id);
            return ResponseEntity.ok(product);
        } else {
            logger.warn("Product with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    //todo
    ////////////////////////    Logging Exceptions:   ////////////////////////////
    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            orderService.createOrder(order);
            logger.info("Order created successfully");
            logger.debug(order.toString());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Error creating order", e);
            return ResponseEntity.badRequest().build();
        }
    }


}
