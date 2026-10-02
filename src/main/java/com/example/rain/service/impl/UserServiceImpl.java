package com.example.rain.service.impl;

import com.example.rain.model.User;
import com.example.rain.repository.UserRepository;
import com.example.rain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String username, String rawPassword) {
        String encoded = passwordEncoder.encode(rawPassword);
        User u = new User(username, encoded, "ROLE_USER");
        return userRepository.save(u);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }
}
