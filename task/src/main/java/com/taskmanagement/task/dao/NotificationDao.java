package com.taskmanagement.task.dao;

import com.taskmanagement.task.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationDao extends JpaRepository<Notification, Integer> {
}
