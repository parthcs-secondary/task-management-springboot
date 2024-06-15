package com.taskmanagement.task.controller;

import com.taskmanagement.task.model.Notification;
import com.taskmanagement.task.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;
    @PostMapping("create")
    public Notification createNotification(@RequestParam String message,@RequestParam int task_id){
            return notificationService.createNotification(message, task_id);
    }

    @GetMapping("get")
    public List<Notification> getAllNotifications(){
        return notificationService.getAllNotifications();
    }

}
