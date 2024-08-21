package com.task.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.tracker.entity.Task;
import com.task.tracker.service.TaskService;



@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TaskService ts;
	
	@PostMapping("/add")
	public Task addTask(@RequestBody Task entity) {
		//TODO: process POST request
		return ts.addTask(entity);
	}
	
	@PutMapping("update/{id}")
	public Task updateTask(@PathVariable Integer id, @RequestParam String desc) {
		//TODO: process PUT request
		return ts.updateTask(id,desc);
	}
	
	@DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Integer id) {
        ts.deleteTask(id);
    }

    @PutMapping("/progress/{id}")
    public Task markInProgress(@PathVariable Integer id) {
        return ts.markInProgress(id);
    }

    @PutMapping("/done/{id}")
    public Task markDone(@PathVariable Integer id) {
        return ts.markDone(id);
    }

    @GetMapping("/list")
    public List<Task> listTasks() {
        return ts.listTasks();
    }

    @GetMapping("/list/{status}")
    public List<Task> listTasksByStatus(@PathVariable String status) {
        return ts.listTasksByStatus(status);
    }
	
}
