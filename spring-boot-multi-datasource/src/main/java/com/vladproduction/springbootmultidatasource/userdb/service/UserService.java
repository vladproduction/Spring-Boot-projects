package com.vladproduction.springbootmultidatasource.userdb.service;

import com.vladproduction.springbootmultidatasource.userdb.entity.User;
import com.vladproduction.springbootmultidatasource.userdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vladproduction on 11-Apr-24
 */

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public void updateWithError(){
        userRepository.updateWithError();
    }

}
