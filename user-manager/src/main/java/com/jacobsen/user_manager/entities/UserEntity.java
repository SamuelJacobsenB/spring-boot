package com.jacobsen.user_manager.entities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jacobsen.user_manager.exceptions.user.InvalidUserException;
import com.jacobsen.user_manager.validation.UserValidation;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "users")
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String name;
    private String email;
    private String password;

    public UserEntity(String name, String email, String password) {
        UserValidation validation = new UserValidation(name, email, password);

        if (!validation.isValid()) {
            throw new InvalidUserException(validation.error());
        }

        this.name = name;
        this.email = email;
        this.password = hashPassword(password);
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        System.out.println(encoder.encode(password));

        return encoder.encode(password);
    } 

    public String name() {
        return this.name;
    }

    public String email() {
        return this.email;
    }
}
