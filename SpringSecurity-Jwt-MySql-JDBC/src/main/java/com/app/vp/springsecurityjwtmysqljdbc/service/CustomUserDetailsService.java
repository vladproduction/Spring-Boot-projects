package com.app.vp.springsecurityjwtmysqljdbc.service;

import com.app.vp.springsecurityjwtmysqljdbc.model.User;
import com.app.vp.springsecurityjwtmysqljdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * This service responsible for such mechanism:
 * -we send by Postman username to the db and check if we have this user at all;
 * -if we got it (User) object --> then
 * -we got by this service UserDetails data, that were going to use in SecurityConfig;
 * */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Method return standard UserDetails data for existing user from db;
     * -logic is: to find at 1-step; and get details by this user at 2-step for springframework.User ;
     * */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("=== UserDetailsService start ===");
        User user = findUser(username);
        //if user is not found (or not exist at all)
        if(user == null){
           throw new UsernameNotFoundException("User not found");
        }
        //returning data but as SpringFramework object User based by our user we got from db
        return new org.springframework.security.core.userdetails.User(
                user.getName(), //private String name from model.User
                user.getPassword(), //private String password from model.User
                new ArrayList<>()); //array of permissions (which roles user has)
    }

    /**
     * just finding user from db
     * */
    private User findUser(String username){
        return userRepository.findByUsername(username);
    }
}
