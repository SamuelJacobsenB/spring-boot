package com.jacobsen.user_manager.validation;

public class UserValidation {
    private String name;
    private String email;
    private String password;

    private boolean isValid = true;
    private String error;

    public UserValidation(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

        this.validateName();
        this.validateEmail();
        this.validatePassword();
    }

    private void validateName() {
        if (name.length() < 3 || name.length() > 50) {
            this.isValid = false;
            this.error = "Nome deve ter entre 3 e 50 caracteres";
            return;
        }
    }

    private void validateEmail() {
        if (!email.contains("@") || !email.contains(".")) {
            this.isValid = false;
            this.error = "Email inválido";
            return;
        }
    }

    private void validatePassword() {
        if (password.length() < 8 || password.length() > 15) {
            this.isValid = false;
            this.error = "Senha deve ter entre 8 a 15 caracteres";
            return;
        }

        if (password.contains(" ")) {
            this.isValid = false;
            this.error = "Senha deve conter espaços";
            return;
        }
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String error() {
        return this.error;
    }
}
