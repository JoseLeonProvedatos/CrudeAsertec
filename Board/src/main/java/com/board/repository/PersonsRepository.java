package com.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.entity.Persons;

public interface PersonsRepository extends JpaRepository<Persons, Long> {
	public Persons findByName(String name);
	public Persons findById(long id);
}
