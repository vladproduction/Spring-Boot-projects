package com.vladproduction.inversionofcontrolexample.exampleHello;

public class HelloImpl implements Hello {
    private String s;

    public HelloImpl(String hi) {
        s = hi;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public void sayHi() {
        System.out.println(s);
    }
}
