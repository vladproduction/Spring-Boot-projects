package com.vladproduction.springtransactions.services;

import com.vladproduction.springtransactions.dao.PaymentDao;
import com.vladproduction.springtransactions.models.Account;
import com.vladproduction.springtransactions.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by vladproduction on 31-Mar-24
 */

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public Payment savePayment(Payment payment){
        return paymentDao.save(payment);
    }

    public Optional<Payment> findPaymentById(Long id){
        return paymentDao.findById(id);
    }

    public List<Payment> findAllPayments(){
        return new ArrayList<>(paymentDao.findAll());
    }

    public int updatePaymentById(Long id, Payment paymentCandidate){
        Optional<Payment> payment = findPaymentById(id);
        if(payment.isPresent()){
            if(paymentCandidate.getSale_info() != null){
                payment.get().setSale_info(paymentCandidate.getSale_info());
            }
            if(paymentCandidate.getPrice() != 0){
                payment.get().setPrice(paymentCandidate.getPrice());
            }
            if(paymentCandidate.getStatus() != null){
                payment.get().setStatus(paymentCandidate.getStatus());
            }
            paymentDao.save(payment.get());
            return 1;
        }else {
            System.out.println("Payment not found with ID: " + id);
            return 0;
        }
    }

    public int deletePaymentById(Long id) {
        Optional<Payment> payment = findPaymentById(id);
        if (payment.isPresent()) {
            paymentDao.deleteById(id); // method in DAO
            return 1; // Deleting success
        } else {
            System.out.println("Payment not found with ID: " + id + ". Deleting fail");
            return 0; // Deleting fail
        }
    }
}
