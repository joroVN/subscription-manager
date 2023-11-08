package com.softuni.subscriptionmanager.model.dto;

import com.softuni.subscriptionmanager.model.validation.FieldMatch;
import com.softuni.subscriptionmanager.model.validation.UniqueUserEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@FieldMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords do not match."
)
public class UserRegisterDTO {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Size(min = 5)
    private String password;

    private String confirmPassword;
    @NotBlank(message = "Email should be provided")
    @Email(message = "Email should be valid")
    @UniqueUserEmail(message = "Email already in use")
    private String email;

    public String getUsername() {
        return username;
    }

    public UserRegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
