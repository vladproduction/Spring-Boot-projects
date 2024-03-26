package com.vladproduction.transactionspringbootapp.dto;

import com.vladproduction.transactionspringbootapp.entity.OrderInfo;
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
public class OrderRequest {

    private OrderInfo orderInfo;
    private PaymentInfo paymentInfo;

}
