package com.taller.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller.model.User;

public interface UserRepository extends  JpaRepository<User, Integer>{

	
	public User findByUsername(String username);
}
