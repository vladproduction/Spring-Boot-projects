package com.app.vp.tokenwork.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * to generate token
 * */
@Service
public class MyJwtService {

    private String SECRET = "BarcelonaBarcelonaBarcelonaBarcelonaBarcelona";

    public String generateToken(String userName, String password){
        Map<String, Object> map = new HashMap<>();
        map.put("password", password);
        return createToken(userName, map);
    }

    /**
     *
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
     *
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
     *
     * */
    public String extractUserName(String token){
        Claims claims = extractAllClaims(token);
        String subject_userName = claims.getSubject();
        return subject_userName;
    }

    /**
     *
     * */
    public Date extractExpiration(String token){
        Claims claims = extractAllClaims(token);
        Date expiration = claims.getExpiration();
        return expiration;
    }

}
