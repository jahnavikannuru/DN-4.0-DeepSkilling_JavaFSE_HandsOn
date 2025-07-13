package com.example.jwt_auth.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private static final String SECRET_KEY = "secretkey";

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        logger.info("Start: /authenticate");
        logger.debug("Authorization Header: {}", authHeader);
        String username = getUser(authHeader);
        logger.debug("Decoded username: {}", username);
        String token = generateJwt(username);
        logger.debug("Generated JWT token: {}", token);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        logger.info("End: /authenticate");
        return map;
    }

    private String getUser(String authHeader) {
        logger.debug("Entering getUser with header: {}", authHeader);
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            logger.warn("Invalid Authorization header");
            return null;
        }
        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
        logger.debug("Decoded credentials string: {}", decodedString);
        int colonIndex = decodedString.indexOf(':');
        if (colonIndex == -1) {
            logger.warn("No colon found in credentials");
            return null;
        }
        return decodedString.substring(0, colonIndex);
    }

    @SuppressWarnings("deprecation")
	private String generateJwt(String user) {
        logger.debug("Generating JWT for user: {}", user);
        return Jwts.builder()
            .setSubject(user)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1200000))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact();
    }
}

