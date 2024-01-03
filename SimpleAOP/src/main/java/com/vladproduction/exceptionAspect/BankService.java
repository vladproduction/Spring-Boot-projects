package com.vladproduction.exceptionAspect;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {

    private static Map<Integer, Person> clients = new HashMap<>();

    public Person getPersonById(int id, double account){
        if(clients.get(id) != null){
            return clients.get(id);
        }
        if(id < 1){
            throw new RuntimeException("Incorrect id");
        }
        Person person = new Person(id, account);
        clients.put(id, person);
        return person;
    }

    public void withdrawal(Person person, double withdraw){

            if(withdraw > person.getAccount()){
                throw new RuntimeException("Denied, check balance; " + (person.getAccount() - withdraw));
            }
            else {
                System.out.println("Success! Your balance is: " + (person.getAccount() - withdraw));
                System.out.println("Last withdrawal = " + withdraw);
            }

    }







}
