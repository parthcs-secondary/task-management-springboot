package com.taskmanagement.task.service;

import com.taskmanagement.task.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import com.taskmanagement.task.dao.UserDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;
    public List<Users> getAllUsers() {
        return userDao.findAll();
    }

    public Optional<Users> getUser(int id) {
        return userDao.findById(id);
    }

    public Users addUser(Users user) {
        return userDao.save(user);
    }

    public String updateUser(Users user, int id) {

        String username = user.getUsername();
        String email = user.getEmail();
        userDao.updateUser(username, email, id);
        return "Success";
    }

    public String deleteUser(int id) {
        userDao.deleteById(id);
        return "success";
    }
}
