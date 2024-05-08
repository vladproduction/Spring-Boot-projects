package com.app.vp.springsecurityjwtmysqljdbc.service;

import com.app.vp.springsecurityjwtmysqljdbc.model.User;
import com.app.vp.springsecurityjwtmysqljdbc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        userRepository.createUser(user);
    }

}
