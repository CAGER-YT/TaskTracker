package com.task.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.tracker.dao.TaskDao;
import com.task.tracker.entity.Task;

@Service
public class TaskService {

	@Autowired
	TaskDao td;
	
	public Task addTask(Task entity) {
		
		return td.addTask(entity);
	}
	
	public Task updateTask(Integer id, String desc) {
		return td.updateTask(id,desc);
	}
	
    public void deleteTask(Integer id) {
        td.deleteTask(id);
    }

    public Task markInProgress(Integer id) {
        return td.markInProgress(id);
    }

    public Task markDone(Integer id) {
        return td.markDone(id);
    }

    public List<Task> listTasks() {
        return td.listTasks();
    }

    public List<Task> listTasksByStatus(String s) {
        return td.listTasksByStatus(Task.Status.valueOf(s.toUpperCase()));
    }
	
}
