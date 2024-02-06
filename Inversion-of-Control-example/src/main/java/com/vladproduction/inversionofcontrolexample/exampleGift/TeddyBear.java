package com.vladproduction.inversionofcontrolexample.exampleGift;

public class TeddyBear implements Toy {
    private int size;
    private String type;
    private double price;

    public TeddyBear(int size, String type, double price) {
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
        return "TeddyBear{" +
                "size="
                + size + ", type="
                + type + ", price=" + price + '}';
    }
}
