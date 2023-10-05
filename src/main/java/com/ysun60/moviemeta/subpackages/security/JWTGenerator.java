package com.ysun60.moviemeta.subpackages.security;

import com.ysun60.moviemeta.subpackages.controller.AuthController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwt;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

import static com.ysun60.moviemeta.subpackages.security.SecurityConstants.JWTexpiryTime;
import static com.ysun60.moviemeta.subpackages.security.SecurityConstants.JwtSecret;
@Component
public class JWTGenerator {
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime() + JWTexpiryTime);


        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256,key)
                .compact();
        return token;
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser()
                .setSigningKey(JwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(JwtSecret).parseClaimsJws(token);
            return true;
        }catch(Exception e){
            throw new AuthenticationCredentialsNotFoundException("Invalid token");
        }
    }
}
