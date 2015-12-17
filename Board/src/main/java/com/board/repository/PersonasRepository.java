package com.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.entity.Personas;

public interface PersonasRepository extends JpaRepository<Personas, Long> {
	public Personas findByNombre(String nombre);
}
