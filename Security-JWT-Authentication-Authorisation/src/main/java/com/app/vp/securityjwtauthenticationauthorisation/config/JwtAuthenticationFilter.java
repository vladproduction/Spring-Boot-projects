package com.app.vp.securityjwtauthenticationauthorisation.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor //using any field
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

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

        //3)finishing validation process
        //check if we have user && is user not yet authenticated
        if(userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            //check if we have user within the database
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            //check if token is still valid or not
            if(jwtService.isTokenValid(jwt, userDetails)){
                //if token is valid we need to update security context and send it to dispatcher servlet
                //creating password (in order of security context we need it)
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                //setting details by request in web
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //updating security context holder
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        //need to the next filter be executed, so we pass filter chain
        filterChain.doFilter(request, response);


    }
}

















