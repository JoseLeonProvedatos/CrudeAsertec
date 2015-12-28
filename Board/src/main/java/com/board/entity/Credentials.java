package com.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Credentials {
	@Id
	@Column(name = "id", length = 100, nullable = false, unique = true)
	private long id;
	
	@Column(name = "user", length = 30, nullable = false)
	private String user;
	
	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	@Column(name = "role", length = 20, nullable = false)
	private String role;
	
	public Credentials() {
	}
	
	public Credentials(long id, String user, String password, String role) {
		this.id = id;
		this.user = user;
		this.password = password;
		this.role = role;
	}
	
	public long getId() {
		return id;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
