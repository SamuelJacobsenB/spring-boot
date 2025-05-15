package com.jacobsen.user_manager.infra;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.jacobsen.user_manager.exceptions.user.InvalidUserException;
import com.jacobsen.user_manager.exceptions.user.UserNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(InvalidUserException.class)
    private ResponseEntity<String> invalidUserHandler(InvalidUserException exception) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> userNotFoundHandler(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
 