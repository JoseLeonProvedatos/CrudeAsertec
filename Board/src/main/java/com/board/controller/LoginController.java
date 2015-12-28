package com.board.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boar.util.Const;
import com.board.entity.Credentials;
import com.board.repository.CredentialsRepository;

import org.springframework.web.bind.annotation.RequestMethod;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(value = "/user")
public class LoginController {
	
	@Autowired
	private CredentialsRepository credentialsRepository;
	
	@CrossOrigin
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public LoginResponse login(@RequestBody final UserLogin login) throws ServletException {
		Credentials credentials = credentialsRepository.findByUser(login.user);
		System.out.println("User: " + credentialsRepository.findAll());
		
		if (login.user == null || login.password == null) {
            throw new ServletException("Invalid username/password");
        }
		
		if (credentials == null) {
			throw new ServletException("User not found");
		} else if (!credentials.getPassword().equals(login.password)) {
			throw new ServletException("Incorrect password");
		}
		
        return new LoginResponse(Jwts.builder().setSubject(credentials.getUser())
        										.claim("roles", credentials.getRole())
        										.setIssuedAt(new Date())
        										.signWith(SignatureAlgorithm.HS256, Const.superSecret)
        										.compact());
	}
	
    private static class UserLogin {
        public String user;
        public String password;
    }
	
	@SuppressWarnings("unused")
    private static class LoginResponse {
        public String token;

        public LoginResponse(final String token) {
            this.token = token;
        }
    }
	
}
