package com.example.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.todolist.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(final String username);
	
	@Query("select u from User u where u.id = ?#{principal.id}")
	User loggedInAs();
	
	
			

}
