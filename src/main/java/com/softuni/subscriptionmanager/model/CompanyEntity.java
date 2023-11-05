package com.softuni.subscriptionmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "companies")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    private String email;

    @ManyToOne
    private RoleEntity role;

    public Long getId() {
        return id;
    }

    public CompanyEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CompanyEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CompanyEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public RoleEntity getRole() {
        return role;
    }

    public CompanyEntity setRole(RoleEntity role) {
        this.role = role;
        return this;
    }
}
