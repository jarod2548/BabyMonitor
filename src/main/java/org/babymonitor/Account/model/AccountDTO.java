package org.babymonitor.Account.model;

import jakarta.validation.constraints.*;

// =========DTO=============//
public class AccountDTO {

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;

    
    private String roles;

    // standard constructor
    public AccountDTO(String name, String mail, String pswrd, String role) {
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

    public void setRoles(String role) {
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

    public Account convert() {
        return new Account(this.username, this.email, this.password, "USER");
    }
}
