package com.fsd.taskmanager.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.taskmanager.bo.ParentTaskVO;
import com.fsd.taskmanager.bo.TaskVO;
import com.fsd.taskmanager.entity.ParentTask;
import com.fsd.taskmanager.entity.Task;
import com.fsd.taskmanager.repository.ParentManagerRepository;
import com.fsd.taskmanager.repository.TaskManagerRepository;
import com.fsd.taskmanager.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskManagerRepository taskManagerRepository;
	@Autowired
	private ParentManagerRepository parentManagerRepository;
	
	
	public List<TaskVO> getAllTasks(){
		
		List<TaskVO> taskVOList = new ArrayList<TaskVO>();
		List<Task> tasks =taskManagerRepository.findAll();
		for(Task task: tasks) {
			TaskVO taskVO=new TaskVO();
			taskVO.setTaskId(task.getTaskId());
			taskVO.setTask(task.getTaskName());
			taskVO.setParentTaskId(task.getParentTask().getParentTaskId());
			taskVO.setParentTask(task.getParentTask().getParentTaskName());
			
			taskVO.setPriority(task.getPriority());
			taskVO.setStartDate(task.getStartDate());
			taskVO.setEndDate(task.getEndDate());
			taskVO.setStatus(task.getStatus());
			
			taskVOList.add(taskVO);
			
		}
		return taskVOList;
	}

	public void saveTask(TaskVO taskVO) {
		
		Task task=new Task();
		task.setEndDate(taskVO.getEndDate());
		task.setPriority(taskVO.getPriority());
		task.setStartDate(taskVO.getStartDate());
		task.setStatus("A");
		task.setTaskName(taskVO.getTask());

		ParentTask parent=new ParentTask();
		List<ParentTaskVO> parentList=getAllParentTasks();
		parent.setParentTaskName(taskVO.getParentTask());
		for(ParentTaskVO parentVO:parentList) {
			if(taskVO.getParentTask().equalsIgnoreCase(parentVO.getParentTaskName())) {
				parent.setParentTaskId(parentVO.getParentTaskId());
			}
			
		}
		if(taskVO.getParentTaskId()==null) {
			parentManagerRepository.save(parent);
		}
		task.setParentTask(parent);
		
		
		
		taskManagerRepository.save(task);
	}
	
	public TaskVO getTask(String taskId) {
		Optional<Task> optTask = taskManagerRepository.findById(Long.parseLong(taskId));

		TaskVO taskVO=new TaskVO();
		taskVO.setTaskId(optTask.get().getTaskId());
		taskVO.setTask(optTask.get().getTaskName());
		taskVO.setParentTaskId(optTask.get().getParentTask().getParentTaskId());
		taskVO.setParentTask(optTask.get().getParentTask().getParentTaskName());
		
		taskVO.setPriority(optTask.get().getPriority());
		taskVO.setStartDate(optTask.get().getStartDate());
		taskVO.setEndDate(optTask.get().getEndDate());
		taskVO.setStatus(optTask.get().getStatus());
		

		return taskVO;
	}

	public void updateTask(TaskVO taskVO) {
		Task task=new Task();
		task.setTaskId(taskVO.getTaskId());
		task.setEndDate(taskVO.getEndDate());
		task.setPriority(taskVO.getPriority());
		task.setStartDate(taskVO.getStartDate());
		task.setStatus(taskVO.getStatus());
		task.setTaskName(taskVO.getTask());

		ParentTask p= getParentTasks(taskVO.getParentTaskId());
		//p.setParentTaskId(taskVO.getParentTaskId());
		p.setParentTaskName(taskVO.getParentTask());
		task.setParentTask(p);
		
		
		taskManagerRepository.save(task);
	}

	public List<ParentTaskVO> getAllParentTasks() {
		List<ParentTaskVO> parentTaskVOList = new ArrayList<ParentTaskVO>();
		List<ParentTask> parentTasks =parentManagerRepository.findAll();
		for(ParentTask parentTask: parentTasks) {
			ParentTaskVO parentTaskVO=new ParentTaskVO();
			parentTaskVO.setParentTaskId(parentTask.getParentTaskId());
			parentTaskVO.setParentTaskName(parentTask.getParentTaskName());
			parentTaskVOList.add(parentTaskVO);
			
		}
		return parentTaskVOList;
	}
	
	public ParentTask getParentTasks(Long parentId) {
		Optional<ParentTask> optParent = parentManagerRepository.findById(parentId);
		return optParent.get();
	}


}
