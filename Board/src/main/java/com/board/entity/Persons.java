package com.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persons {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 11, nullable = false, unique = true)
	private long id;
	
	@Column(name = "ci", length = 10, nullable = false, unique = true)
	private long ci;
	
	@Column(name = "name", length = 30, nullable = false)
	private String name;
	
	@Column(name = "lastname", length = 30, nullable = false)
	private String lastname;
	
	@Column(name = "gender", length = 1, nullable = false)
	private String gender;
	
	@Column(name = "phone", length = 10, nullable = false)
	private long phone;
	
	public Persons() {
	}
	
	public Persons(long id, long ci, String name, String lastname, String gender, long phone) {
		this.id = id;
		this.ci = ci;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.phone = phone;
	}
	
	public long getId() {
		return id;
	}
	
	public long getCi() {
		return ci;
	}
	
	public String getname() {
		return name;
	}
	
	public String getlastname() {
		return lastname;
	}
	
	public String getgender() {
		return gender;
	}
	
	public long getphone() {
		return phone;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setCi(long ci) {
		this.ci = ci;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public void setlastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setgender(String gender) {
		this.gender = gender;
	}
	
	public void setphone(long phone) {
		this.phone = phone;
	}
}
