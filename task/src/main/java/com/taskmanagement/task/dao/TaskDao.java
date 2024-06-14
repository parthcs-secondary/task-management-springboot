package com.taskmanagement.task.dao;

import com.taskmanagement.task.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Tasks, Integer> {
}
