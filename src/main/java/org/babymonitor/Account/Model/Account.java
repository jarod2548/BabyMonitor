package org.babymonitor.Account.Model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// =========DBO/Entity======//
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String email;

    private String password;

    private String roles;

    // standard constructor
    public Account(String name, String mail, String pswrd, String role) {
        username = name;
        email = mail;
        password = pswrd;
        roles = role;
    }

    // setters
    public void setUsername(String name) {
        username = name;
    }

    public void setEmail(String mail) {
        email = mail;
    }

    public void setPassword(String pswrd) {
        password = pswrd;
    }

    public void setRole(String role) {
        roles = role;
    }

    // getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return roles;
    }

    public String getpassword() {
        return password;
    }

}
