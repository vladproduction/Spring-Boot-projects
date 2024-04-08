package com.vladproduction.springtransactions.controllers;

import com.vladproduction.springtransactions.models.Customer;
import com.vladproduction.springtransactions.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 14-Mar-24
 */

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public Optional<Customer> findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @GetMapping("/all")
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @PatchMapping("/{id}/update")
    public int updateCustomerById(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomerById(id, customer);
    }

    @DeleteMapping("/{id}/delete")
    public int deleteCustomerById(@PathVariable Long id) {
        return customerService.deleteCustomerById(id);
    }

}
