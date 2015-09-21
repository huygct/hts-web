package com.huyvn.happytostudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Huy Nghi on 9/17/2015.
 */
@Document(collection = "user")
public class UserModel {

    @Id
    private String id;

    private String email;
    private String name;
    private String enabled;
    private String password;

    private Role role;

    public UserModel(String email, String name, String enabled, String password, Role role) {
        this.email = email;
        this.name = name;
        this.enabled = enabled;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", enabled='" + enabled + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}