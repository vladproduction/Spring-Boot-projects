package com.vladproduction;

import com.vladproduction.annotation.UserDao;
import com.vladproduction.aopAdvance.MyService;
import com.vladproduction.demo.MySimpleService;
import com.vladproduction.exceptionAspect.BankService;
import com.vladproduction.exceptionAspect.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    @Autowired
    private BankService bankService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private MySimpleService mySimpleService;
    private final MyService myService;

    public MainApp(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run(String... args) throws Exception {
//        //myService.doAction(-1);
//        Integer res = myService.add(2, 2);
//        System.out.println("res = " + res);
//        mySimpleService.doSomething();
//        System.out.println("-------annotations-------------------------");
//        User user = userDao.getUser(20);
//        System.out.println("user = " + user);
        System.out.println("------------exceptions---------------------");
        Person person1 = bankService.getPersonById(1, 2000.0);
        Person person2 = bankService.getPersonById(2, 3000.0);
        Person person3 = bankService.getPersonById(3, 8000.0);
        Map<Integer, Person> clients = new HashMap<>();
        clients.put(1, person1);
        clients.put(2, person2);
        clients.put(3, person3);
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println("------------trying withdrawal--------------------");
        bankService.withdrawal(person1, 1000.0);
    }


    public static void main(String[] args) {
        SpringApplication.run(MainApp.class);

    }
}
