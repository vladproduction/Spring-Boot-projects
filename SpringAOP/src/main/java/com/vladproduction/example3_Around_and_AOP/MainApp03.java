package com.vladproduction.example3_Around_and_AOP;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp03 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example3_Around_and_AOP/aop.xml");
        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
//        PassengerDaoImpl passengerDao = (PassengerDaoImpl) context.getBean("passengerDao");
        System.out.println(passengerDao.getPassenger(100));
        context.close();
    }
}
