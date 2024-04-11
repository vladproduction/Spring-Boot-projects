package com.vladproduction.springbootmultidatasource.userdb.controller;

import com.vladproduction.springbootmultidatasource.userdb.entity.User;
import com.vladproduction.springbootmultidatasource.userdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vladproduction on 11-Apr-24
 */

@RestController
@RequestMapping("api/user_db")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){

        return userRepository.save(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){

        return userRepository.findAll();
    }
}
