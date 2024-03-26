package com.vladproduction.transactionspringbootapp.service;

import com.vladproduction.transactionspringbootapp.dto.OrderAck;
import com.vladproduction.transactionspringbootapp.dto.OrderRequest;
import com.vladproduction.transactionspringbootapp.entity.OrderInfo;
import com.vladproduction.transactionspringbootapp.entity.PaymentInfo;
import com.vladproduction.transactionspringbootapp.repo.OrderRepo;
import com.vladproduction.transactionspringbootapp.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.vladproduction.transactionspringbootapp.util.PaymentValidation.validatePaymentInfo;

/**
 * Created by vladproduction on 26-Mar-24
 */

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Transactional
    public OrderAck placingOrder(OrderRequest orderRequest){

        OrderInfo orderInfo = orderRequest.getOrderInfo();
        orderRepo.save(orderInfo);

        PaymentInfo paymentInfo = orderRequest.getPaymentInfo();
        validatePaymentInfo(paymentInfo);

        orderInfo.setProductName(paymentInfo.getProductName());
        orderRepo.save(orderInfo);
        paymentRepo.save(paymentInfo);

        return new OrderAck("Success", paymentInfo.getAmount(), paymentInfo);

    }




}
