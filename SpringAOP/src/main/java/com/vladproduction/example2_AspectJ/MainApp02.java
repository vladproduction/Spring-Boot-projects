package com.vladproduction.example2_AspectJ;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp02 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("example2_AspectJ/aop.xml");
        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
        System.out.println(passengerDao.getPassenger(100));
        context.close();
    }
}
