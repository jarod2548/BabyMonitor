package org.babymonitor.Account.model;

public class LoginDTO {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        password = Password;
    }

    public LoginDTO(String Email, String Password) {
        email = Email;
        password = Password;
    }

    public LoginDTO() { }

    public Account convert(){
        return new Account(email, password);
    }
}
