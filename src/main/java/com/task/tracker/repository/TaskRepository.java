package com.task.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.tracker.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

	List<Task> findByStatus(Task.Status status);
}
