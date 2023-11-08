package com.softuni.subscriptionmanager.model;

import jakarta.persistence.*;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @ManyToMany
    private List<SubscriptionEntity> subscriptions;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<RoleEntity> userRoles = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<SubscriptionEntity> getSubscriptions() {
        return subscriptions;
    }

    public UserEntity setSubscriptions(List<SubscriptionEntity> subscriptions) {
        this.subscriptions = subscriptions;
        return this;
    }

    public List<RoleEntity> getUserRoles() {
        return userRoles;
    }

    public UserEntity setUserRoles(List<RoleEntity> userRoles) {
        this.userRoles = userRoles;
        return this;
    }
}
