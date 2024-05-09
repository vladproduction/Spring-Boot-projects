package com.app.vp.springsecurityjwtmysqljdbc.controller;

import com.app.vp.springsecurityjwtmysqljdbc.model.AuthRequest;
import com.app.vp.springsecurityjwtmysqljdbc.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tokenController")
public class TokenController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest request){
        try{
            Authentication authentication = authenticationProvider
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()));
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return jwtService.generateToken(request.getUsername(), request.getPassword());

    }

}
