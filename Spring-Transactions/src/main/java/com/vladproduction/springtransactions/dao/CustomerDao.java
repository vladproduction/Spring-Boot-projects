package com.vladproduction.springtransactions.dao;

import com.vladproduction.springtransactions.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vladproduction on 30-Mar-24
 */

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
