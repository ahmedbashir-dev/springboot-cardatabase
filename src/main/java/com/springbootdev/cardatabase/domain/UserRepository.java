package com.springbootdev.cardatabase.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
	public Optional<User> findByUsername(String username);
}
