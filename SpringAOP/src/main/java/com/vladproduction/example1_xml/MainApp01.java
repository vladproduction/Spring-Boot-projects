package com.vladproduction.example1_xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp01 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example1_xml/aop.xml");
        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
        System.out.println(passengerDao.getPassenger(100));
        context.close();
    }
}
