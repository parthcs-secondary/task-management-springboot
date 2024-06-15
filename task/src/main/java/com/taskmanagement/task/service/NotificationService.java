package com.taskmanagement.task.service;

import com.taskmanagement.task.dao.NotificationDao;
import com.taskmanagement.task.dao.TaskDao;
import com.taskmanagement.task.model.Notification;
import com.taskmanagement.task.model.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    NotificationDao notificationDao;
    @Autowired
    TaskDao taskDao;
    public Notification createNotification(String message, int task_id) {
        Tasks task = taskDao.findById(task_id).orElse(null);
        if(task == null){
            throw new IllegalArgumentException("Task is not present");
        }

        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setTask(task);
        return notificationDao.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationDao.findAll();
    }
}
