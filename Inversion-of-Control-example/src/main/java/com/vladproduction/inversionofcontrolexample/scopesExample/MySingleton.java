package com.vladproduction.inversionofcontrolexample.scopesExample;

import org.springframework.context.ApplicationContext;

public class MySingleton {

    private String name;
    private ApplicationContext applicationContext;
    private MyPrototype prototype;

    public MySingleton(String name, MyPrototype prototype, ApplicationContext applicationContext) {
        this.name = name;
        this.prototype = prototype;
        this.applicationContext = applicationContext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyPrototype getPrototype() {
        return prototype;
    }

    public void setPrototype(MyPrototype prototype) {
        this.prototype = prototype;
    }

    public void doAction(){
        prototype = applicationContext.getBean(MyPrototype.class);
        System.out.println(name + "; " + prototype.getType() + "; hashCode prototype = " + prototype.hashCode()
        + " singleton hasCode: " + hashCode());
    }
}
