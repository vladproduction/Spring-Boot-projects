package com.vladproduction.jmeterexample.model;

/**
 * Created by vladproduction on 14-Mar-24
 */

public class Car {

    private int id;
    private String model;
    private boolean isAvailable;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "; MODEL: " + model + '\'' +
                "; IS_AVAILABLE: " + isAvailable +
                "; PRICE: " + price;
    }
}
