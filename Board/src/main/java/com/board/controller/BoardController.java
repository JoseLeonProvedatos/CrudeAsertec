package com.board.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boar.util.Parser;
import com.board.entity.Personas;
import com.board.repository.PersonasRepository;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping(value = "/api")
public class BoardController {
	
	@Autowired
	private PersonasRepository personasRepository;
	
	@CrossOrigin
	@RequestMapping(value = "board", method = RequestMethod.GET, produces = "application/json")
	public String showBoard() {
		//Personas persona1 = new Personas(998765432, "Juan", "Perez", "M", 999456456);
		//personasRepository.save(persona1);
		
		Parser<Personas> parser = new Parser<Personas>(personasRepository.findAll());
		return parser.parseList();
	}
	
	@RequestMapping(value = "role/{role}", method = RequestMethod.GET)
	public Boolean login(@PathVariable final String role, final HttpServletRequest request) throws ServletException {
		final Claims claims = (Claims)request.getAttribute("claims");

		return ((String)claims.get("roles")).contains(role);
	}
}
