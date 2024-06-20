package com.assignment.offer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class that defines the security settings for the application.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures the security filter chain.
     *
     * @param http the {@link HttpSecurity} to modify
     * @return the {@link SecurityFilterChain} to be used
     * @throws Exception if an error occurs
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity in this example
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll() // Allow public access to certain endpoints
                .anyRequest().authenticated() // All other endpoints require authentication
            ).httpBasic(httpBasicCustomizer -> httpBasicCustomizer // Customize HTTP Basic authentication
                .realmName("Your Realm")
                .authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint())
            );

        return http.build();
    }

    /**
     * Provides an in-memory user details service with a sample user.
     *
     * @return the {@link UserDetailsService} to be used
     */
    @Bean
    public UserDetailsService userDetailsService() {
        var user = User.withUsername("user")
                .password(passwordEncoder().encode("password"))
                .authorities("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    /**
     * Provides a password encoder.
     *
     * @return the {@link PasswordEncoder} to be used
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
