package com.vladproduction.transactionspringbootapp.dto;

import com.vladproduction.transactionspringbootapp.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vladproduction on 26-Mar-24
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderAck {

    private String status;
    private double payableAmount;
    private PaymentInfo paymentInfo;

}
