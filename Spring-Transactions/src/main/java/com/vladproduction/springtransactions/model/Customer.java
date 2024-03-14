package com.vladproduction.springtransactions.model;

import java.util.Objects;

/**
 * Created by vladproduction on 14-Mar-24
 */

public class Customer {

    private Long id;
    private String customerName;
    private boolean isValidAccount;

    public Customer(Long id, String customerName, boolean isValidAccount) {
        this.id = id;
        this.customerName = customerName;
        this.isValidAccount = isValidAccount;
    }

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isValidAccount() {
        return isValidAccount;
    }

    public void setValidAccount(boolean validAccount) {
        isValidAccount = validAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return isValidAccount == customer.isValidAccount && Objects.equals(id, customer.id) && Objects.equals(customerName, customer.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, isValidAccount);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", isValidAccount=" + isValidAccount +
                '}';
    }
}
