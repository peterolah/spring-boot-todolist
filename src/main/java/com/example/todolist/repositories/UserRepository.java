package com.example.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.example.todolist.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(final String username);
	
	
			

}
