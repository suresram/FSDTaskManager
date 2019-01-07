package com.fsd.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsd.taskmanager.entity.ParentTask;

@Repository
public interface ParentManagerRepository extends JpaRepository<ParentTask,Long>{

}
