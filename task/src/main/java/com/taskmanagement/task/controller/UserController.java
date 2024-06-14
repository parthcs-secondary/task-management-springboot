package com.taskmanagement.task.controller;

import com.taskmanagement.task.model.Users;
import com.taskmanagement.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/get")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public Optional<Users> getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @PostMapping("add")
    public Users addUser(@RequestBody Users user){
        return userService.addUser(user);
    }

    @PostMapping("update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody Users user){
        return userService.updateUser(user, id);
    }

    @PostMapping("delete/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "Success";
    }

}
