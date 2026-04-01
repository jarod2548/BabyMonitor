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
    @GeneratedValue
    private Long id;

    @Column(name = "naam")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "wachtwoord")
    private String password;

    @Column(name = "rol")
    private String roles;


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
    public Long getId(){
      return id;
    }
  
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

}
