package com.taskmanagement.task.service;

import com.taskmanagement.task.dao.TaskDao;
import com.taskmanagement.task.dao.UserDao;
import com.taskmanagement.task.model.Tasks;
import com.taskmanagement.task.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

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
        return taskDao.save(task);
    }
}
