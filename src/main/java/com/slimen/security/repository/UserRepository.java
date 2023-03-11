package com.slimen.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.slimen.security.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByEmail(String email);
	
}
