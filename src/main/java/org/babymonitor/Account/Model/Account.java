package org.babymonitor.Account.Model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// =========DBO/Entity======//
@Entity
@Table(name = "users")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naam")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "wachtwoord")
    private String password;

    @Column(name = "rol")
    private String roles;

    public Account() {
        // REQUIRED
    }

    // standard constructor
    public Account(String name, String mail, String pswrd, String role) {
        username = name;
        email = mail;
        password = pswrd;
        roles = role;
    }

    public Account(String name, String password){
        username = name;
        this.password = password;
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

    public Long getId() {
        return id;
    }

    public String GetRole() {
        return roles;
    }
    public String GetPassword(){return password;}

}
