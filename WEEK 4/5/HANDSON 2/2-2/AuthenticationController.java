package com.example.jwt_auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        logger.info("Start: /authenticate");
        logger.debug("Authorization Header: {}", authHeader);
        String username = getUser(authHeader);
        logger.debug("Decoded username: {}", username);
        Map<String, String> map = new HashMap<>();
        map.put("token", "");
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
        String username = decodedString.substring(0, colonIndex);
        return username;
    }
}
