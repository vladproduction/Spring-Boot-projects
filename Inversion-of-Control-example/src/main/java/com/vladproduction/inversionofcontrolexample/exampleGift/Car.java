package com.vladproduction.inversionofcontrolexample.exampleGift;

public class Car implements Toy {
    private int size;
    private String type;
    private double price;

    public Car(int size, String type, double price) {
        this.size = size;
        this.type = type;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price + 50;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "size=" + size +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
