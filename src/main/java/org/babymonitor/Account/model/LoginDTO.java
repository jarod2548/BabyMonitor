package org.babymonitor.Account.model;

public class LoginDTO {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        email = Email;
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


    
    public Account convert() {
        Account account = new Account();
        account.setEmail(this.email);
        account.setPassword(this.password);
        return account;
    }
}
