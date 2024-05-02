package com.app.vp.securityjwtauthenticationauthorisation.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "7BF8E06D43B15260755FFB425F30927A1486CCF41FA2DA4CB6345904C407A0EA";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject); //subject of te token
    }

    //method to extract one single claim
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //1:09
    //method if we want to use only userDetails

    //method to help generate a token
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername()) //as unique
                .setIssuedAt(new Date(System.currentTimeMillis())) //if token still valid or not
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) //how long this token should be valid (24h)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) //algorithm
                .compact(); //compact & return token

    }

    //method to extract all claims
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
