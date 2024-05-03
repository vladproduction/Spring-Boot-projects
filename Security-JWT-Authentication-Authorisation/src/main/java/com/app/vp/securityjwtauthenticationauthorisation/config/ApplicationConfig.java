package com.app.vp.securityjwtauthenticationauthorisation.config;

import com.app.vp.securityjwtauthenticationauthorisation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Class holds all configuration for beans around application
 * */
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository userRepository;


    //fetch the user from our database
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> userRepository.findByEmail(username) //return as optional
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found")); //providing exception case
    }

    //creating bean for authentication provider (responsible to take all inform for providing authentication)
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        //for authProvider we need to specify two properties:
        //1)
        authProvider.setUserDetailsService(userDetailsService());
        //2)
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
