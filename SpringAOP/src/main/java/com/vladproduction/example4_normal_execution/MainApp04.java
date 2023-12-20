package com.vladproduction.example4_normal_execution;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp04 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("example4_normal_execution/aop.xml");
        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");;
        System.out.println(passengerDao.getPassenger(100));
        context.close();
    }
}
