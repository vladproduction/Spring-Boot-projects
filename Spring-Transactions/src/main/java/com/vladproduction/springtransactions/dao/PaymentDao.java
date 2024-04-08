package com.vladproduction.springtransactions.dao;

import com.vladproduction.springtransactions.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vladproduction on 31-Mar-24
 */

public interface PaymentDao extends JpaRepository<Payment, Long> {
}
