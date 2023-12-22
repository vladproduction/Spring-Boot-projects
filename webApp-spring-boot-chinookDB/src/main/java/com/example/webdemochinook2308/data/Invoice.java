package com.example.webdemochinook2308.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InvoiceId", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;

    @Column(name = "InvoiceDate", nullable = false)
    private Instant invoiceDate;

    @Column(name = "BillingAddress", length = 70)
    private String billingAddress;

    @Column(name = "BillingCity", length = 40)
    private String billingCity;

    @Column(name = "BillingState", length = 40)
    private String billingState;

    @Column(name = "BillingCountry", length = 40)
    private String billingCountry;

    @Column(name = "BillingPostalCode", length = 10)
    private String billingPostalCode;

    @Column(name = "Total", nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

}