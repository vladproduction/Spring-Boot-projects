package com.vladproduction.springtransactions.services;

import com.vladproduction.springtransactions.dao.CustomerDao;
import com.vladproduction.springtransactions.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by vladproduction on 14-Mar-24
 */

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    //basic crud operations

    public Customer saveCustomer(Customer customer){
        return customerDao.save(customer);
    }

    public Optional<Customer> findCustomerById(Long id){
        return customerDao.findById(id);
    }

    public List<Customer> findAllCustomers(){
        return new ArrayList<>(customerDao.findAll());
    }

    public int updateCustomerById(Long id, Customer customerCandidate){
        Optional<Customer> customer = findCustomerById(id);
        if(customer.isPresent()){
            if(customerCandidate.getFirst_name() != null){
                customer.get().setFirst_name(customerCandidate.getFirst_name());
            }
            if (customerCandidate.getSecond_name() != null){
                customer.get().setSecond_name(customerCandidate.getSecond_name());
            }
            if (customerCandidate.getAge() != 0){
                customer.get().setAge(customerCandidate.getAge());
            }
            customerDao.save(customer.get());
            return 1;
        }else {
            System.out.println("Customer not found with ID: " + id);
            return 0;
        }
    }

    /**public int updateCustomerById(Long id, Customer customerCandidate) {
        return findCustomerById(id)
                .map(c -> {
                    // Update fields directly using null-safe setters
                    c.setFirst_name(customerCandidate.getFirst_name());
                    c.setSecond_name(customerCandidate.getSecond_name());
                    c.setAge(customerCandidate.getAge());
                    customerDao.save(c);
                    return 1;
                })
                .orElseGet(() -> {
                    System.out.println("Customer not found with ID: " + id);
                    return 0;
                });
    }*/ //todo: have to update

    public int deleteCustomerById(Long id) {
        Optional<Customer> customerById = findCustomerById(id);
        if (customerById.isPresent()) {
            customerDao.deleteById(id); // method in DAO
            return 1; // Deleting success
        } else {
            System.out.println("Customer not found with ID: " + id + ". Deleting fail");
            return 0; // Deleting fail
        }
    }

}
