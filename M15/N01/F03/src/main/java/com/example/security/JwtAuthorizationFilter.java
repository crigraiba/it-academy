package com.example.security;

import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.MalformedJwtException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
	
	private final String
		HEADER = "Authorization",
		PREFIX = "Bearer ",
		SECRET = "mySecretKey";
	
	@Override
	protected void doFilterInternal(
		HttpServletRequest request,
		HttpServletResponse response,
		FilterChain filterChain
	) throws ServletException, IOException {
		try {
			if (existeJWTToken(request, response)) {
				Claims claims = validateToken(request);
				
				if(claims.get("authorities") != null)
					setUpSpringAuthentication(claims);
				else
					SecurityContextHolder.clearContext();
			} else
				SecurityContextHolder.clearContext();
			
			filterChain.doFilter(request, response);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
		}
	}
	
	private Claims validateToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER)
			.replace(PREFIX, "");
		
		return Jwts.parser()
			.setSigningKey(SECRET.getBytes())
			.parseClaimsJws(jwtToken)
			.getBody();
	}
	
	private void setUpSpringAuthentication(Claims claims) {
		@SuppressWarnings("unchecked")
		List<String> authorities = (List<String>) claims.get("authorities");
		
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
			claims.getSubject(),
			null,
			authorities.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList())
		);
		
		SecurityContextHolder.getContext()
			.setAuthentication(auth);
	}
	
	private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse response) {
		String authenticationHeader = request.getHeader(HEADER);
		
		if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
			return false;
		else
			return true;
	}

}
