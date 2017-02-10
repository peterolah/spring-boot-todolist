package com.example.todolist.startup;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.todolist.entities.Role;
import com.example.todolist.entities.Task;
import com.example.todolist.entities.User;
import com.example.todolist.repositories.TaskRepository;
import com.example.todolist.repositories.UserRepository;

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		User user = new User();
		
		user.setUsername("petero");
		user.setPassword(encoder.encode("petike"));
		user.setEmail("rehabit.munka@gmail.com");
		user.setEnabled(true);
		user.setFirstname("Peter");
		user.setLastname("Olah");
		
		
		
		userRepo.save(user);
		
		
		System.out.println("initial user petero saved to DB");
		
		
	 Task t1 = new Task();
	 t1.setName("Create REST service for todolist app");
	 t1.setDescription("Create the basic rest endpoints for the todo application");
	 t1.setOwner(user);
	 t1.setAssignee(user);
	 
	 taskRepo.save(t1);
	 
	 
	 Task t2 = new Task();
	 t2.setName("Secure todolist app");
	 t2.setDescription("Introduce and configure Spring Security");
	 t2.setOwner(user);
	 t2.setAssignee(user);
	 
	 taskRepo.save(t2);
		
		
		
		
		
		
	}
	
	

}
