package com.app.vp.springsecurityjwtmysqljdbc.controller;

import com.app.vp.springsecurityjwtmysqljdbc.model.User;
import com.app.vp.springsecurityjwtmysqljdbc.service.UserService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/signup")
public class SignUpController {

    @Autowired
    private UserService userService;

    @PostMapping
    @PermitAll
    @ResponseStatus(CREATED)
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    /**
     * 1)request log, pass
     * 2)response token
     * */

}
