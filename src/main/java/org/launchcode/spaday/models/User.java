package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class User {
    private int id;
    private static int nextId=1;
    private String username;
    private String email;
    private String password;
    private LocalDateTime signDate;

    public User() {
        this.id = nextId;
        nextId++;
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.signDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getSignDate() {
        return signDate;
    }

    @Override
    public String toString() {
        return username;
    }


}
