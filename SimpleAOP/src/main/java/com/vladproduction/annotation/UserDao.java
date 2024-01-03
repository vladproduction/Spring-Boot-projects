package com.vladproduction.annotation;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserDao {

    private static Map<Integer, User> userMap = new HashMap<>();
    @LogAnnotation
    public User getUser(int id){
        if(userMap.get(id) != null){
            return userMap.get(id);
        }
        User user = new User(id);
        userMap.put(id, user);
        return user;
    }
}
