package com.demo.pharmacy_claims.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Use new syntax to disable CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/claims/**").permitAll()  // Allow access to this endpoint
                        .anyRequest().authenticated()  // Secure all other endpoints
                )
                .httpBasic(withDefaults());  // New recommended way for Basic Auth

        return http.build();
    }
}
