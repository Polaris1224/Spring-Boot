package com.example.UserMicroservice.JWT;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtAuthenticationHelper jwtHelper ;
	
	@Autowired
	UserDetailsService userDetailsService ;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestHeader = request.getHeader("Authorization") ;
		
		String username = null ;
		String token = null ;
		if(requestHeader != null && requestHeader.startsWith("Bearer")) {
			token = requestHeader.substring(7) ;
			username = jwtHelper.getUsernameFromToken(token) ;
			if(username != null) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(username) ;
				if(!jwtHelper.isTokenExpired(token) && SecurityContextHolder.getContext().getAuthentication() == null) {
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(token, null, userDetails.getAuthorities()) ;
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		}
		
		filterChain.doFilter(request, response);
	}
}
