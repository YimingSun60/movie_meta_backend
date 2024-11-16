package com.ysun60.moviemeta.subpackages.security;

import com.ysun60.moviemeta.subpackages.controller.AuthController;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

import static com.ysun60.moviemeta.subpackages.security.SecurityConstants.JWTexpiryTime;
import static com.ysun60.moviemeta.subpackages.security.SecurityConstants.JwtSecret;
// It is a vulnerable implementation
// key is not stored securely
// key is not rotated and generated every time the application starts
@Component
public class JWTGenerator {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private String username = "";
    public String generateToken(Authentication authentication){
        username = authentication.getName();
        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + JWTexpiryTime);


        return Jwts.builder()
                .setIssuer("MovieMeta")
                .setSubject(username)
                .setIssuedAt(currentDate)
                //.signWith(SignatureAlgorithm.HS256, key)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUsernameFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch(Exception e){
            e.printStackTrace();e.printStackTrace();
            return false;
        }
    }
}
