package com.vladproduction.logginglevelsspring.model;



/**
 * Created by vladproduction on 13-Mar-24
 */


public class Order {

    private Long id;
    private String customerName;
    private double totalPrice;

    public Order(Long id, String customerName, double totalPrice) {
        this.id = id;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public Order() {

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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
