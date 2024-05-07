package com.app.vp.tokenwork.controller;


import com.app.vp.tokenwork.service.MyJwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/myJwtController")
public class MyJwtController {

    @Autowired
    private MyJwtService jwtService;

    @GetMapping
    public String getToken(@RequestParam String username, String password){
        return jwtService.generateToken(username, password);
    }

    @PostMapping
    public String getUserName(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        int n = "Bearer ".length();
        String token = header.substring(n);
        return jwtService.extractUserName(token);
    }

}
