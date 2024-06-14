package com.taskmanagement.task.dao;

import com.taskmanagement.task.model.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<Users, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE users SET email=:email, username=:username WHERE id=:id", nativeQuery = true)
    void updateUser(String username, String email, int id);
}
