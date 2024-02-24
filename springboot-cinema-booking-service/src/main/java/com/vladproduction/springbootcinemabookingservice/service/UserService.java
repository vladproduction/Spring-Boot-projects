package com.vladproduction.springbootcinemabookingservice.service;


import com.vladproduction.springbootcinemabookingservice.model.impl.User;

import java.util.List;

public interface UserService extends CrudService<User>{
    User getUserByEmail(String email);

    List<User> getUsersByName(String name, int pageSize, int pageNum);
}
