package org.babymonitor.Account.Model;// ==========DTO============//

import jakarta.persistence.*;

// =========DBO/Entity======//
@Entity
@Table(name = "account")
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
    private String rol;

    public Account() {
        // REQUIRED
    }

    // standard constructor
    public Account(String name, String mail, String pswrd) {
        username = name;
        email = mail;
        password = pswrd;
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

    // getters
    public String GetUsername() {
        return username;
    }

    public String GetEmail() {
        return email;
    }

    public String GetPassword(){return password;}

}
