package ru.jdrims.cloudstorage.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenGenerateUtil {

    public String generateToken(UserDetails userDetails) {
        Date timeToken = new Date(new Date().getTime() + 1000L * 60 * 60 * 24 * 30); //30 дней
        String SECRET_KEY = "KEY";
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(timeToken)
                .signWith(SignatureAlgorithm.ES512, SECRET_KEY)
                .compact();
    }
}
