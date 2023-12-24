package com.erenberik.flightsearchapi;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Base64;

@SpringBootApplication
public class FlightSearchApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightSearchApiApplication.class, args);
        // Generate a random 256-bit (32-byte) key
        byte[] keyBytes = new byte[32]; // 256 bits
        new java.security.SecureRandom().nextBytes(keyBytes);

        // Encode the key in Base64
        String base64Key = Base64.getEncoder().encodeToString(keyBytes);

        System.out.println("Generated JWT Key: " + base64Key);
    }

}
