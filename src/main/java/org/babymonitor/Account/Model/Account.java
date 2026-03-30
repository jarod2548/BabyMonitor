package org.babymonitor.Account.Model;

import jakarta.persistence.*;
// ==========DTO============//



// =========DBO/Entity======//
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;
    private String Role;

    // standard constructor
    public Account(String name, String mail, String pswrd, String role) {
        username = name;
        email = mail;
        password = pswrd;
        Role = role;
    }

    public Account() {

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
    public void SetRol(String role){Role = role;}

    // getters
    public String GetUsername() {
        return username;
    }

    public String GetEmail() {
        return email;
    }

    public String GetPassword() {
        return password;
    }

    public String GetRol(){return Role;}

}
