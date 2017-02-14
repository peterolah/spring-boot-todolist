package com.example.todolist.startup;

import java.util.HashSet;
import java.util.Set;
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
public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		User user1 = new User();
		
		user1.setUsername("petero");
		user1.setPassword(encoder.encode("petike"));
		user1.setEmail("rehabit.munka@gmail.com");
		user1.setEnabled(true);
		user1.setFirstname("Peter");
		user1.setLastname("Olah");
		
		Set<Role> roles= new HashSet<>();
		roles.add(new Role("ACTUATOR"));
		roles.add(new Role("ADMIN"));
		user1.setRoles(roles);
		
		
		
		userRepo.save(user1);
		
		
User user2 = new User();
		
		user2.setUsername("klovasz");
		user2.setPassword(encoder.encode("tuskebokor"));
		user2.setEmail("tuskebokor86@gmail.com");
		user2.setEnabled(true);
		user2.setFirstname("Katalin");
		user2.setLastname("Lovasz");
		
//		Set<Role> roles= new HashSet<>();
//		roles.add(new Role("ACTUATOR"));
//		roles.add(new Role("ADMIN"));
//		user2.setRoles(roles);
		
		
		
		userRepo.save(user2);
		
		
		
		
		
		
	 Task t1 = new Task();
	 t1.setName("Create REST service for todolist app");
	 t1.setDescription("Create the basic rest endpoints for the todo application");
	 t1.setOwner(user1);
	 t1.setAssignee(user1);
	 
	 taskRepo.save(t1);
	 
	 
	 Task t2 = new Task();
	 t2.setName("Secure todolist app");
	 t2.setDescription("Introduce and configure Spring Security");
	 t2.setOwner(user1);
	 t2.setAssignee(user1);
	 
	 taskRepo.save(t2);
	 
	 Task t3 = new Task();
	 t3.setName("Test myTasksAsAssignee");
	 t3.setDescription("Test myTasksAsAssignee endpoint");
	 t3.setOwner(user2);
	 t3.setAssignee(user1);
	 
	 taskRepo.save(t3);
		
		
		
		
		
		
	}
	
	

}
