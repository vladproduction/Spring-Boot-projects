package com.vladproduction.sbappstarting.repositiries;

import java.util.List;

import com.vladproduction.sbappstarting.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);

  Customer findById(long id);
}