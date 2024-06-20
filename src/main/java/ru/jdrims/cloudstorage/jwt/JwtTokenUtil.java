package ru.jdrims.cloudstorage.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenUtil {

    public String generateToken(UserDetails userDetails) {
        Date timeToken = new Date(new Date().getTime() + 1000L * 60 * 60 * 24 * 30); // 30 дней
        String SECRET_KEY = "KEY";
        byte[] encodedKey = Base64.getEncoder().encode(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        Key secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "HmacSHA512");
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(timeToken)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
