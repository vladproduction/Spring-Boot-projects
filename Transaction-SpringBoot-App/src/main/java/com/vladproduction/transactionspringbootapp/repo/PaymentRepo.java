package com.vladproduction.transactionspringbootapp.repo;

import com.vladproduction.transactionspringbootapp.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vladproduction on 26-Mar-24
 */

public interface PaymentRepo extends JpaRepository<PaymentInfo, Long> {
}
