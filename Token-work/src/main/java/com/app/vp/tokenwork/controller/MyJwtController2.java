package com.app.vp.tokenwork.controller;

import com.app.vp.tokenwork.service.MyJwtService;
import com.app.vp.tokenwork.service.MyJwtService2;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("api/myJwtController2")
public class MyJwtController2 {

    @Autowired
    private MyJwtService2 jwtService2;

    //[GET]: generateToken REST API
    //return token for current user
    @GetMapping("/generateToken")
    public String generateToken(@RequestParam String username, String password){
        String token = jwtService2.generateToken(username, password);
        return token;
    }

    //[POST]: extractUsername REST API
    //return username
    @PostMapping("/extractUsername")
    public String extractUsername(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        int n = "Bearer ".length();
        String token = header.substring(n);
        String username = jwtService2.extractUsername(token);
        return username;
    }

    //[POST]: extractExpiration REST API
    //return expiration date
    @PostMapping("/extractExpiration")
    public Date extractExpiration(HttpServletRequest request){
        String header = request.getHeader("ExpirationDate");
        int n = "Bearer ".length();
        String token = header.substring(n);
        Date expiration = jwtService2.extractExpiration(token);
        return expiration;
    }
}
