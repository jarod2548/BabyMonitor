package org.babymonitor.config;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.babymonitor.Account.Model.Account;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JWTService {
    private String jwtSecret = "yQ9Zt5rYH9g4e2jTQfK8fN0+V7kW3s5xZp6yVb1cTnE=";
    SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    long expiration = 3600000;


    public String generateToken(Account model) {

        return Jwts.builder()
                .setSubject(model.getUsername())
                .claim("role", model.getRole())
                .claim("ID", model.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public String getRole(String token) {
        return (String) Jwts.parser().verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("role");
    }

    public Long getID(String token) {
        Object claim = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("ID");

        if (claim instanceof Integer) {
            return ((Integer) claim).longValue();
        } else if (claim instanceof Long) {
            return (Long) claim;
        } else if (claim instanceof String) {
            return Long.parseLong((String) claim);
        } else {
            throw new IllegalArgumentException("Invalid ID claim type");
        }
    }
}
