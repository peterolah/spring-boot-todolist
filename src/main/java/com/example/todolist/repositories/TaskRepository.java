package com.example.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.entities.Task;

//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface TaskRepository extends JpaRepository<Task, Long> {

	

}
