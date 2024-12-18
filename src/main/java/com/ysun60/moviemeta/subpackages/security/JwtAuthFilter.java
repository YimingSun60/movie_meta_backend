package com.ysun60.moviemeta.subpackages.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class JwtAuthFilter extends OncePerRequestFilter {

    private JWTGenerator jwtGenerator;

    private CustomUserDetailService customUserDetailService;

    @Autowired
    public JwtAuthFilter(JWTGenerator jwtGenerator, CustomUserDetailService customUserDetailService) {
        this.jwtGenerator = jwtGenerator;
        this.customUserDetailService = customUserDetailService;
    }
    // Every request will go through this filter
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getJwtFromRequest(request);
        if(StringUtils.hasText(token)){
            jwtGenerator.validateToken(token);
        }
        if(StringUtils.hasText(token) && jwtGenerator.validateToken(token)) {
            // get username from token
            String username = jwtGenerator.getUsernameFromToken(token);
            // get user details from username
            UserDetails userDetails = customUserDetailService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            //request.setAttribute("userDetails", userDetails);
        }
        else{
            System.out.println("token is null");
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }


}
