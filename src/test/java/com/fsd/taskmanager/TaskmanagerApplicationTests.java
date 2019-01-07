package com.fsd.taskmanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import com.fsd.taskmanager.bo.TaskVO;
import com.fsd.taskmanager.controller.TaskController;
import com.fsd.taskmanager.service.TaskService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskmanagerApplicationTests {
	
	private TaskController controller;
	private TaskService taskService;

	@Before
	public void setUp() throws Exception {
		taskService = Mockito.mock(TaskService.class);
		controller = new TaskController(taskService);
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testMe() {
		String testhome = controller.testHome();
		Assert.assertEquals(testhome, "Project Manager App - Test Task ");
		
	}

	
	@Test
	public void testViewtask() {
		List<TaskVO> taskVOList = new ArrayList<TaskVO>();
		Mockito.when(taskService.getAllTasks()).thenReturn(taskVOList);
		List<TaskVO> task=controller.getTasks();
		Assert.assertNotNull(task);
		Assert.assertNotNull(task);
		//Assert.assertEquals(testhome, "Welcome");
		
	}
	@Test
	public void getTasksById() {
		TaskVO task = new TaskVO();
		task.setEndDate(null);
		task.setParentTask("p1");
		task.setParentTaskId(1L);
		task.setPriority("13");
		task.setStatus("A");
		task.setTask("task");
		task.setTaskId(1L);
		
		Mockito.when(taskService.getTask(Mockito.anyString())).thenReturn(task);
		TaskVO taskVO=controller.getTasksById("1");
		Assert.assertNotNull(task);
		Assert.assertEquals(task.getEndDate(), null);
		Assert.assertEquals(task.getParentTask(), "p1");
		Assert.assertEquals(task.getPriority(), "13");
		Assert.assertEquals(task.getStatus(), "A");
		Assert.assertEquals(task.getTask(), "task");
		task.getParentTaskId();
		
		
		
	}
	
	
	@Test
	public void testSaveTask() {
		TaskVO task=new TaskVO();
		Date now = new Date();
		task.setEndDate(null);
		task.setParentTask("ad");
		//task.setParentTaskId(1);
		task.setPriority("5");task.setStartDate(null);
		task.setStatus("A");
		task.setTask("task");
		
		//Mockito.when(taskService.saveTask(task)).thenReturn("success");
		boolean status=controller.saveTask(task);
		Assert.assertEquals(status, true);
		
		
	}
	
	
	
	@Test
	public void testUpdateTask() {
		TaskVO task=new TaskVO();
		Date now = new Date();
		task.setEndDate(null);
		task.setParentTask("ad");
		//task.setParentTaskId(1);
		task.setPriority("5");task.setStartDate(null);
		task.setStatus("A");
		task.setTask("task");
		
		//Mockito.when(taskService.saveTask(task)).thenReturn("success");
		boolean status=controller.updateTask(task,"1");
		Assert.assertEquals(status, true);
		
		
	}
	
	
	@Test
	public void testDeleteTask() {
		TaskVO task=new TaskVO();
		Mockito.when(taskService.getTask(Mockito.anyString())).thenReturn(task);
		controller.deleteTask("1");
		Assert.assertNotNull(task);
	}
	
	
	
	
}
