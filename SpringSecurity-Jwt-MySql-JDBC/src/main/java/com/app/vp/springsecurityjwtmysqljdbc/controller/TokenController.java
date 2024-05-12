package com.app.vp.springsecurityjwtmysqljdbc.controller;

import com.app.vp.springsecurityjwtmysqljdbc.model.AuthRequest;
import com.app.vp.springsecurityjwtmysqljdbc.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * That controller responsible for:
 * we have to send request and after get security token as response;
 * we can authorize or authenticate;
 */
@RestController
@RequestMapping("api/tokenController")
public class TokenController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    /**
     * we generate token based on AuthRequest request where we have username and password;
     * so basically were generating token only for authorized user,
     * that exist in db
     */
    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest request) {
        try {
            //check by provider for existing user in db
            authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //return generated token
        return jwtService.generateToken(request.getUsername(), request.getPassword());

    }

}
