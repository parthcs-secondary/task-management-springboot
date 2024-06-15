package com.taskmanagement.task.service;

import com.taskmanagement.task.dao.TaskDao;
import com.taskmanagement.task.dao.UserDao;
import com.taskmanagement.task.model.Notification;
import com.taskmanagement.task.model.Tasks;
import com.taskmanagement.task.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    NotificationService notificationService;
    @Autowired
    UserDao userDao;
    @Autowired
    TaskDao taskDao;
    public List<Tasks> getAllTasks() {
        return taskDao.findAll();
    }

    public Optional<Tasks> getTask(int id) {
        return taskDao.findById(id);
    }

    //need correction
    //update or delete on table "tasks" violates foreign key constraint
    public String deleteTask(int id) {
        taskDao.deleteById(id);
        return "Success";
    }


    public Tasks createTask(Tasks task) {
        Users user = userDao.findById(task.getAssigned_to().getId()).orElse(null);
        task.setAssigned_to(user);
        Tasks savedTask = taskDao.save(task);
        notificationService.createNotification("Task " + task.getTitle() + "has been assigned to " + task.getAssigned_to().getUsername(), task.getId());
        return savedTask;
    }

    public Tasks updateTask(int id, Tasks task) {
            Tasks currentTaskDetails = taskDao.findById(id).orElse(null);
            if(currentTaskDetails != null) {
                if (task.getTitle() != null) {
                    currentTaskDetails.setTitle(task.getTitle());
                }
                if (task.getDescription() != null) {
                    currentTaskDetails.setDescription(task.getDescription());
                }
                if (task.getStatus() != null) {
                    currentTaskDetails.setStatus(task.getStatus());
                }
                if (task.getDue_date() != null) {
                    currentTaskDetails.setDue_date(task.getDue_date());
                }
                if (task.getAssigned_to() != null) {
                    Users user = userDao.findById(task.getAssigned_to().getId()).orElse(null);
                    if(user != null){
                        currentTaskDetails.setAssigned_to(user);
                    }
                }
                return taskDao.save(currentTaskDetails);
            }
            return null;
    }
}
