package com.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.entity.Credentials;

public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
	public Credentials findByUser(String user);
}
