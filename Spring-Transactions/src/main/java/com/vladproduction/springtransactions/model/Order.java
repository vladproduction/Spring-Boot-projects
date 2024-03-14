package com.vladproduction.springtransactions.model;

import java.util.Objects;

/**
 * Created by vladproduction on 14-Mar-24
 */

public class Order {

    private Long id;
    private String orderName;
    private double totalPrice;

    public Order(Long id, String orderName, double totalPrice) {
        this.id = id;
        this.orderName = orderName;
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

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(totalPrice, order.totalPrice) == 0 && Objects.equals(id, order.id) && Objects.equals(orderName, order.orderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderName, totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
