package com.board.authorization;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		/*final HttpServletRequest request = (HttpServletRequest)req;
		final String authHeader = request.getHeader("Authorization");
		
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			System.out.println("Missing or invalid authorization header!");
			throw new ServletException("Missing or invalid authorization header!");
		}
		
		final String token = authHeader.substring(7);
		
		try {
			final Claims claims = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody();
			request.setAttribute("claims", claims);
		} catch (SignatureException e) {
			System.out.println("Invalid token!");
			throw new ServletException("Invalid token!");
		}*/
		
		chain.doFilter(req, res);
	}
}
