package com.softuni.subscriptionmanager.model.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AppUserDetails extends User {
    private String email;

    public AppUserDetails(String username,
                          String password,
                          Collection<? extends GrantedAuthority> authorities,
                          String email) {
        super(username, password, authorities);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public AppUserDetails setEmail(String email) {
        this.email = email;
        return this;
    }
}
