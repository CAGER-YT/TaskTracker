package com.task.tracker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.task.tracker.entity.Task;
import com.task.tracker.repository.TaskRepository;

@Repository
public class TaskDao {

	@Autowired
	TaskRepository tr;
	
	public Task addTask(@RequestBody Task entity) {
		//TODO: process POST request
		
		return tr.save(entity);
	}
	
	public Task updateTask(Integer id,String desc) {
		//TODO: process PUT request
		Task task=tr.findById(id).orElseThrow(()->new IllegalArgumentException("Task not Found"));
		task.setDescription(desc);
		return tr.save(task);
	}
	
	public void deleteTask(Integer id) {
        tr.deleteById(id);
    }

    public Task markInProgress(Integer id) {
        Task task = tr.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.setStatus(Task.Status.IN_PROGRESS);
        return tr.save(task);
    }

    public Task markDone(Integer id) {
        Task task = tr.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.setStatus(Task.Status.DONE);
        return tr.save(task);
    }

    public List<Task> listTasks() {
        return tr.findAll();
    }

    public List<Task> listTasksByStatus(Task.Status status) {
        return tr.findByStatus(status);
    }
}
