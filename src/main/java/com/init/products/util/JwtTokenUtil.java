package com.init.products.util;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {
	
	private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	private static final long expiration_time = 60000; //5 min // 60000 = 1 min
	
	public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration_time);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey)
                .compact();
    }
	
	public String validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return "valid";
        } catch (ExpiredJwtException ex) {
            // Token is expired
            return "expired token";
        } catch (JwtException | IllegalArgumentException e) {
            // Token is invalid (failed parsing or verification)
            return "invalid token";
        }
    }

}
