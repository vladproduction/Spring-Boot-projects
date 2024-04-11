package com.vladproduction.globaltransaction2db.service;

import com.vladproduction.globaltransaction2db.entity.person.Person;
import com.vladproduction.globaltransaction2db.entity.user.User;
import com.vladproduction.globaltransaction2db.repository.PersonRepository;
import com.vladproduction.globaltransaction2db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vladproduction on 09-Apr-24
 */

@Service
@Transactional
public class MyService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserRepository userRepository;

    public void process(){

        Person person = new Person();
        person.setName("John");
        person.setAge(26);
        personRepository.save(person);
        System.out.println("========Person saved========");

        User user = new User();
        user.setUserName("Bob");
        user.setUserAge(25);
        userRepository.save(user);
        System.out.println("========User saved========");
    }

}
