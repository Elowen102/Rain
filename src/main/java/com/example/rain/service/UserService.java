package com.example.rain.service;

import com.example.rain.model.User;

import java.util.List;

public interface UserService {
    User register(String username, String rawPassword);
    User findByUsername(String username);
    List<User> listAll();
}
