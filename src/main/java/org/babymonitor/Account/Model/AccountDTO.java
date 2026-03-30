package org.babymonitor.Account.Model;

import jakarta.validation.constraints.*;

// =========DTO=============//
public class AccountDTO {

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String roles;

    // standard constructor
    public AccountDTO(String name, String mail, String pswrd, String role) {
        username = name;
        email = mail;
        password = pswrd;
        roles = role;
    }

    // setters
    public void SetUsername(String name) {
        username = name;
    }

    public void SetEmail(String mail) {
        email = mail;
    }

    public void SetPassword(String pswrd) {
        password = pswrd;
    }

    public void SetRole(String role) {
        roles = role;
    }

    // getters
    public String GetUsername() {
        return username;
    }

    public String GetEmail() {
        return email;
    }

    public String GetRole() {
        return roles;
    }

    public Account convert() {
        return new Account(this.username, this.email, this.password, this.roles);
    }
}
