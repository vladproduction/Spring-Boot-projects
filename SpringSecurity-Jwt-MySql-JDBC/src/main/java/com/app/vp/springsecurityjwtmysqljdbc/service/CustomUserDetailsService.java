package com.app.vp.springsecurityjwtmysqljdbc.service;

import com.app.vp.springsecurityjwtmysqljdbc.model.User;
import com.app.vp.springsecurityjwtmysqljdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("=== UserDetailsService start ===");
        User user = findUser(username);
        if(user == null){
           throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                new ArrayList<>()); //array of permissions (which roles user has)
    }

    private User findUser(String username){
        return userRepository.findByUsername(username);
    }
}
