package com.fsd.taskmanager.bo;

public class TaskVO {

	private Long taskId;
	private String task;
	private Long parentTaskId;
	private String parentTask;
	private String priority;
	private String startDate;
	private String endDate;
	private String status;
	
	
	
	public TaskVO() {
		super();
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public Long getParentTaskId() {
		return parentTaskId;
	}
	public void setParentTaskId(Long parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	public String getParentTask() {
		return parentTask;
	}
	public void setParentTask(String parentTaskName) {
		this.parentTask = parentTaskName;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
