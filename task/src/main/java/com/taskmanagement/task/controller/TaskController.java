package com.taskmanagement.task.controller;


import com.taskmanagement.task.model.Tasks;
import com.taskmanagement.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("get")
    public List<Tasks> getAllTasks() {
        //Expects http://localhost:8080/users/get
        return taskService.getAllTasks();
    }

    @GetMapping("get/{id}")
    public Optional<Tasks> getTask(@PathVariable int id) {
        //Expects http://localhost:8080/users/get/<id>
        return taskService.getTask(id);
    }

    @PostMapping("delete/{id}")
    public String deleteTasks(@PathVariable int id) {
        //Expects http://localhost:8080/users/delete/<id>
        return taskService.deleteTask(id);
    }


    @PostMapping("create")
    public Tasks createTask(@RequestBody Tasks task) {
        /* Expects http://localhost:8080/users/create
        {
        "title": "Assigned Task",
            "description": "This task is assigned upon creation",
            "assigned_to": {
        "id": 2
        },
        "status": "In Progress",
            "due_date": "2024-06-30"
        }*/
        return taskService.createTask(task);
    }

}
