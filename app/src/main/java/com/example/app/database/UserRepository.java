package com.example.app.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
