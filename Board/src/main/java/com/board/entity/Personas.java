package com.board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Personas {
	@Id
	@Column(name = "id", length = 10, nullable = false, unique = true)
	private long id;
	
	@Column(name = "Nombre", length = 30, nullable = false)
	private String nombre;
	
	@Column(name = "Apellido", length = 30, nullable = false)
	private String apellido;
	
	@Column(name = "Sexo", length = 1, nullable = false)
	private String sexo;
	
	@Column(name = "Telefono", length = 10, nullable = false)
	private long telefono;
	
	public Personas() {
	}
	
	public Personas(long id, String nombre, String apellido, String sexo, long telefono) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.telefono = telefono;
	}
	
	public long getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public long getTelefono() {
		return telefono;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
}
