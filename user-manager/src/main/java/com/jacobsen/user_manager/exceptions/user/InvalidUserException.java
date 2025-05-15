package com.jacobsen.user_manager.exceptions.user;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException() {
        super("Informações do usuário inváliadas");
    }

    public InvalidUserException(String message) {
        super(message);
    }
}
