package com.slimen.security.config;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthentificationFilter extends OncePerRequestFilter {
	
	 private final JwtService jwtService;

	@Override
	protected void doFilterInternal(
		@NonNull	HttpServletRequest request,
		@NonNull	HttpServletResponse response,
		@NonNull FilterChain filterChain
			)throws ServletException, IOException {
		// TODO Auto-generated method stub
		// extract this header , is part of our request
		final String authHeader= request.getHeader("Authorization");
		final String jwt;
		final String userEmail;
		if(authHeader==null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		jwt=authHeader.substring(7);
		// todo extrat userEmail from JWT token
		userEmail = jwtService.extractUsername(jwt);
		
		
	}
	
	

}
