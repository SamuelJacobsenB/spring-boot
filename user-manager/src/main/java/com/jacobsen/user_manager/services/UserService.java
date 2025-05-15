package com.jacobsen.user_manager.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.jacobsen.user_manager.repositories.UserRepository;
import com.jacobsen.user_manager.entities.UserEntity;
import com.jacobsen.user_manager.exceptions.user.UserNotFoundException;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public Optional<UserEntity> getUserByEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UserNotFoundException();
        }

        return user;
    }
}
