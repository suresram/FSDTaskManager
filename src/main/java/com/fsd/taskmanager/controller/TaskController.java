package com.fsd.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.taskmanager.bo.ParentTaskVO;
import com.fsd.taskmanager.bo.TaskVO;
import com.fsd.taskmanager.service.TaskService;
import com.fsd.taskmanager.service.impl.TaskServiceImpl;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TaskController {
	@Autowired
	private TaskServiceImpl taskManagerService;
	
	
	public TaskController(TaskService taskService) {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/hometest")
	public String testHome() {
		return "Project Manager App - Test Task ";
	}
	
	@GetMapping("/tasks")
	public List<TaskVO> getTasks() {
		List<TaskVO> tasks =taskManagerService.getAllTasks();
		return tasks;
	}
	
	@GetMapping("/tasks/{taskId}")
	public TaskVO getTasksById(@PathVariable(name="taskId") String taskId) {
		TaskVO task = taskManagerService.getTask(taskId); 
		return task;
	}
	
	@PostMapping(path = "/tasks", consumes = "application/json", produces = "application/json")
	public boolean saveTask(@RequestBody TaskVO task) {
		try {
			
			taskManagerService.saveTask(task);
		}catch(Exception e)
		{
			System.out.println("Save Task Failed : " + e.getMessage());
			return false;
		}
		return true;
	}	
	
	@PutMapping("/tasks/{taskId}")
	public boolean updateTask(@RequestBody TaskVO task, @PathVariable(name="taskId") String taskId) {
		try {
			TaskVO taskExists = taskManagerService.getTask(taskId);
			if(taskExists != null) {
				taskManagerService.updateTask(task);
			}else {
				System.out.println("updateTask: No task available in the task id : " + taskId);
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Update Task Failed : " + e.getMessage());
			return false;
		}
		return true;
	}
	
	@DeleteMapping("/tasks/{taskId}")
	public boolean deleteTask(@PathVariable(name="taskId") String taskId) {
		try {
			TaskVO taskRetrived = taskManagerService.getTask(taskId);
			if(taskRetrived != null) {
				taskRetrived.setStatus("I");
				taskManagerService.updateTask(taskRetrived);
			}else {
				System.out.println("deleteTask: No task available in the task id : " + taskId);
				return false;
			}
		}catch(Exception e)
		{
			System.out.println("Delete Task Failed : " + e.getMessage());
			return false;
		}
		return true;
	}
	
	
	/*@GetMapping("/ParentTasks")
	public List<ParentTaskVO> getParentTasks() {
		List<ParentTaskVO> tasks =taskManagerService.getAllParentTasks();
		return tasks;
	}*/
	
	
	


}
