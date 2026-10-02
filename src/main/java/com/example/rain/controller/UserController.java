package com.example.rain.controller;

import com.example.rain.dto.UserDto;
import com.example.rain.model.User;
import com.example.rain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDto dto) {
        if (userService.findByUsername(dto.getUsername()) != null) {
            return ResponseEntity.badRequest().body("username already exists");
        }
        User u = userService.register(dto.getUsername(), dto.getPassword());
        return ResponseEntity.ok().body("registered");
    }

    @GetMapping("/api/users")
    public ResponseEntity<?> listUsers(Principal principal) {
        List<?> list = userService.listAll().stream()
                .map(u -> {
                    return java.util.Map.of("id", u.getId(), "username", u.getUsername(), "roles", u.getRoles());
                }).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/api/me")
    public ResponseEntity<?> me(Principal principal) {
        if (principal == null) return ResponseEntity.status(401).build();
        return ResponseEntity.ok(java.util.Map.of("username", principal.getName()));
    }
}
