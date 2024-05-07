package com.app.vp.tokenwork.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Service class contain settings for generating token:
 * 1-generateToken(String userName, String password);
 * 2-extractUserName(String token);
 * 3-extractExpiration(String token);
 * */
@Service
public class MyJwtService2 {

    private final String SECRET_KEY = "RonaldoRivaldoRonaldinhoKakaKafuDidaRobertoCarlos";

    //[GET]: generateToken
    public String generateToken(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("password", password);
        return createToken(username, map);
    }

    //[POST]: extractUsername
    public String extractUsername(String token) {
        Claims allClaims = extractAllClaims(token);
        String username = allClaims.getSubject();
        return username;
    }

    //[POST]: extractExpiration
    public Date extractExpiration(String token){
        Claims allClaims = extractAllClaims(token);
        Date expiration = allClaims.getExpiration();
        return expiration;
    }

    private String createToken(String username, Map<String, Object> claims) {
        return Jwts.builder()
                .addClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) //60 minutes till expiration
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


}
