package com.vladproduction.transactionspringbootapp.repo;

import com.vladproduction.transactionspringbootapp.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vladproduction on 26-Mar-24
 */

public interface OrderRepo extends JpaRepository<OrderInfo, Integer> {
}
