package com.example.jwt_auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/countries").hasRole("USER")
	            .requestMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
	            .anyRequest().authenticated()
	        )
	        .httpBasic(withDefaults());
	    return http.build();
	}

}

