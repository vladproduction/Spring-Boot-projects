package com.app.vp.tokenwork.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Service to generate token contain:
 * 1-generateToken(String userName, String password);
 * 2-extractUserName(String token);
 * 3-extractExpiration(String token);
 * */
@Service
public class MyJwtService {

    //secret key as base to create token
    private final String SECRET = "BarcelonaBarcelonaBarcelonaBarcelonaBarcelona";

    /**
     * Method for generate token
     * Map<String, Object> map holds all generated tokens for users
     * @param userName String (for that user)
     * @param password String
     *
     * @return generated token for user (using private method 'createToken')
     * */
    public String generateToken(String userName, String password){
        Map<String, Object> map = new HashMap<>();
        map.put("password", password);
        return createToken(userName, map); //create token for user with concerning claims (map)
    }

    /**
     *Method for creating token (setting meta inform for token)
     * @param userName String
     * @param claims Map<String, Object> claims (specific values that can be needed)
     *
     * @return String value of created token
     * */
    private String createToken(String userName, Map<String, Object> claims){
        return Jwts.builder()
                .addClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    /**
     *Method to get all claims based on SECRET key and token by parsing
     * @param token String token
     *
     * @return Claims: object representing as map (as result of parsing)
     * */
    private Claims extractAllClaims(String token){

        return Jwts
                .parser()
                .setSigningKey(SECRET)
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    /**
     *Method to get username from current token given as param
     * @param token String
     *
     * @return username String
     * */
    public String extractUserName(String token){
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    /**
     *Method to get expiration date from current token given as param
     * @param token String
     *
     * @return expiration Date
     * */
    public Date extractExpiration(String token){
        Claims claims = extractAllClaims(token);
        return claims.getExpiration();
    }

}
