package com.app.vp.securityjwtauthenticationauthorisation.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor //using any field
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        //1)check if we have JWT Token
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        if(authHeader == null || authHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return; //don`t want to rest execution
        }
        //2)extract header of token
        jwt = authHeader.substring(7);
        //extract the userEmail from JWT token;
        userEmail = jwtService.extractUsername(jwt);

    }
}
