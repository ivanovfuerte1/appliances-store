package com.learning.appliancestore.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivanov on 24.3.2018 г..
 */
@Entity
@Table(name = "users")
public class User {
    private Integer id;

    private String email;

    private String fullName;

    private String password;

    private Set<Role> roles;

    public User(String email, String fullName, String password) {
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.roles = new HashSet<>();
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "fullName", nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "password", length = 60, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles")
    public Set<Role> getRoles() {
        return Collections.unmodifiableSet(roles);
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
