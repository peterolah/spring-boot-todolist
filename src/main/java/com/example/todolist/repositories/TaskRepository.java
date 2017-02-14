package com.example.todolist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.todolist.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	
	@Query("select t from Task t where t.owner.id = ?#{principal.id}")
	List<Task> myTasksAsOwner();
	
	@Query("select t from Task t where t.assignee.id = ?#{principal.id}")
	List<Task> myTasksAsAssignee();

	

}
