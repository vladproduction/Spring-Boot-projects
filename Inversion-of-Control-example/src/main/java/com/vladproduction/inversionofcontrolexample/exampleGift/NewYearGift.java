package com.vladproduction.inversionofcontrolexample.exampleGift;

import java.util.ArrayList;

public class NewYearGift {
    private ArrayList<Gift> list = new ArrayList<Gift>();

    public void setList(ArrayList<Gift> list) {

        this.list = list;
    }

    public NewYearGift() {
    }

    public void print() {
        double sum = 0;
        String s = "";
        for (Gift g : list) {
            s += g + "\n";
            sum += g.price();
        }
        System.out.println(s + "Total price: " + sum);
        System.out.println("----------------");
    }
}