
package com.fsd.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fsd.taskmanager.entity.Task;



@Repository
public interface TaskManagerRepository extends JpaRepository<Task,Long>{
	
	
	 
}

