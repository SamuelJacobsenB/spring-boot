package com.jacobsen.user_manager.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jacobsen.user_manager.entities.UserEntity;
import com.jacobsen.user_manager.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userDto) {
        UserEntity user = userService.createUser(userDto);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Optional<UserEntity>> getUser(@PathVariable String email) {
        Optional<UserEntity> user = userService.getUserByEmail(email);

        return ResponseEntity.ok(user);
    }
}
