package com.board.controller;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boar.util.Parser;
import com.board.entity.Persons;
import com.board.repository.PersonsRepository;

@RestController
@RequestMapping(value = "/api")
public class BoardController {
	
	@Autowired
	private PersonsRepository personsRepository;
	
	@CrossOrigin
	@RequestMapping(value = "board", method = RequestMethod.GET, produces = "application/json")
	public String showBoard() throws ServletException {
		//Personas persona1 = new Personas(998765432, "Juan", "Perez", "M", 999456456);
		//personasRepository.save(persona1);
		
		Parser<Persons> parser = new Parser<Persons>(personsRepository.findAll());
		return parser.parse();
	}
	
	/*@RequestMapping(value = "role/{role}", method = RequestMethod.GET)
	public Boolean login(@PathVariable final String role, final HttpServletRequest request) throws ServletException {
		final Claims claims = (Claims)request.getAttribute("claims");

		return ((String)claims.get("roles")).contains(role);
	}*/
	
	@RequestMapping(value = "addNew", method = RequestMethod.POST)
	public ResponseEntity<Resp> addNew(@RequestBody final Persons person) throws ServletException {
		personsRepository.save(person);
		Resp resp = new Resp();
		resp.setText("Saved");
		
		return new ResponseEntity<Resp>(resp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public ResponseEntity<Resp> edit(@RequestBody final Persons person) throws ServletException {
		if (personsRepository.findById(person.getId()) == null) {
			throw new ServletException("The person does not exist in data base");
		}
		
		personsRepository.save(person);
		Resp resp = new Resp();
		resp.setText("Updated");
		
		return new ResponseEntity<Resp>(resp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "remove/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Resp> remove(@PathVariable("id") final long id) throws ServletException {
		System.out.println("Name: " + id);
		if (personsRepository.findById(id) == null) {
			throw new ServletException("The person does not exist in data base");
		}
		
		personsRepository.delete(id);
		Resp resp = new Resp();
		resp.setText("Removed");
		
		return new ResponseEntity<Resp>(resp, HttpStatus.OK);
	}
	
	@SuppressWarnings("unused")
	private static class Resp {
		public String text;

		public void setText(String text) {
			this.text = text;
		}
	}
}
