package com.example.simplyfly;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTFilter extends OncePerRequestFilter {

 @Autowired private JWTCheck jwtCheck;
 @Autowired private UserDetailsService userDetailsService;

 @Override
 protected void doFilterInternal(
         HttpServletRequest req,
         HttpServletResponse res,
         FilterChain chain)
     throws ServletException, IOException {

     String header = req.getHeader("Authorization");
     if (header != null && header.startsWith("Bearer ")) {
         String token = header.substring(7);
         if (jwtCheck.validateToken(token)) {
             Claims claims = jwtCheck.extractUsername(token);
             String email = claims.getSubject();

             UserDetails user = userDetailsService.loadUserByUsername(email);
             UsernamePasswordAuthenticationToken auth =
                 new UsernamePasswordAuthenticationToken(
                     user, null, user.getAuthorities());
             SecurityContextHolder.getContext().setAuthentication(auth);
         }
     }
     chain.doFilter(req, res);
 }
}
