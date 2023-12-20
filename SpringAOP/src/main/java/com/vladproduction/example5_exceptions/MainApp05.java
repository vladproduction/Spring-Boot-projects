package com.vladproduction.example5_exceptions;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp05 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("example5_exceptions/aop.xml");
        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
        //to program continue - have to explicit catch the exception
        try{
            System.out.println(passengerDao.getPassenger(0));
        }catch (Exception e){
            System.out.println("Exception should be proceed if id < '0';");
        }
        context.close();
    }
}
