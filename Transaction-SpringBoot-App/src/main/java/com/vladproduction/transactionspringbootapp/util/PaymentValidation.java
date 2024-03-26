package com.vladproduction.transactionspringbootapp.util;

import com.vladproduction.transactionspringbootapp.entity.PaymentInfo;
import com.vladproduction.transactionspringbootapp.exceptions.InsufficientMoneyException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vladproduction on 26-Mar-24
 */

public class PaymentValidation {

    private static final Map<String, Double> paymentDetails = new HashMap<>();

    static {
        paymentDetails.put("Mobile", 20000.0);
        paymentDetails.put("Laptop", 60000.0);
        paymentDetails.put("Tablet", 30000.0);
        paymentDetails.put("Charger", 1000.0);
    }

    public static boolean validatePaymentInfo(PaymentInfo paymentInfo){

        if (paymentInfo.getAmount() < paymentDetails.get(paymentInfo.getProductName())){
            throw new InsufficientMoneyException("insufficient amount");
        } else {
            return true;
        }
    }
}
