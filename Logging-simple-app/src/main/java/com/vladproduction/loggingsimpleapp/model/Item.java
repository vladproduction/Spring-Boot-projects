package com.vladproduction.loggingsimpleapp.model;

/**
 * Created by vladproduction on 12-Mar-24
 */

public class Item {

    private int a, b;
    private ActionType actionType;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        return "Item{" +
                "a=" + a +
                ", b=" + b +
                ", actionType=" + actionType +
                '}';
    }
}


