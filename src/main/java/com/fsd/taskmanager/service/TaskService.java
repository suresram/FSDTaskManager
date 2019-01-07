package com.fsd.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fsd.taskmanager.bo.ParentTaskVO;
import com.fsd.taskmanager.bo.TaskVO;

@Service
public interface TaskService {

	public List<TaskVO> getAllTasks();

	public void saveTask(TaskVO task);

	public TaskVO getTask(String taskId);

	public void updateTask(TaskVO taskVO);

	public List<ParentTaskVO> getAllParentTasks();
}
