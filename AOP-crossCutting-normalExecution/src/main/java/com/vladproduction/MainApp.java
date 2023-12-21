package com.vladproduction;

import com.vladproduction.management.Flight;
import com.vladproduction.management.Passenger;
import com.vladproduction.management.Ticket;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {


        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("management/aop.xml");

        Flight flight = (Flight) context.getBean("flight");

        flight.print();
        System.out.println(flight.getId());
        flight.setId("AA5678");

        System.out.println(flight.getCompany());

        for (Passenger passenger : flight.getPassengers()) {
            System.out.println(passenger.getName());
            System.out.println("---");
            passenger.print();
        }

        Ticket ticket = (Ticket) context.getBean("ticket");
        ticket.setNumber("0987654321");

        context.close();


    }
}
