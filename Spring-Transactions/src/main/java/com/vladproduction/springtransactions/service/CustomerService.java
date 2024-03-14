package com.vladproduction.springtransactions.service;

import com.vladproduction.springtransactions.model.Customer;
import com.vladproduction.springtransactions.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vladproduction on 14-Mar-24
 */

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public void saveCustomer(Customer customer){
        customerRepo.saveCustomer(customer);
    }

}
