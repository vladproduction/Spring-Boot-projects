package com.vladproduction.exceptionAspect;

public class Person {

    private int id;
    private double account;

    public Person(int id, double account) {
        this.id = id;
        this.account = account;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", account=" + account +
                '}';
    }
}
