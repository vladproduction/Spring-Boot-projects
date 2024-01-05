package com.vladproduction.restValidation.controllers;

import com.vladproduction.restValidation.models.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping(path = "/api/web/validation")
public class ValidationController {

    @PostMapping
    public ResponseEntity<Void> postValidMethod(@RequestBody @Valid User user){
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/userObject")
    public ResponseEntity<Void> postValidMethodInnerUserObject(@RequestBody @Valid User user){
        return ResponseEntity.ok().build();
    }



    @PostMapping(path = "/userList")
    public ResponseEntity<Void> postValidMethodUserList(@RequestBody @Valid List<User> userList){
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/userObjectList")
    public ResponseEntity<Void> postValidMethodUserObjectList(
            @RequestBody @Valid List<User> userList){
        return ResponseEntity.ok().build();
    }
}
