package org.babymonitor.Account.DTO;

import org.babymonitor.Account.Model.Account;

public class LoginDTO {
    private String username;
    private String password;

    public String getUsername(){ return username;}
    public void setUsername(String Username){username = Username;}
    public String getPassword(){return password;}
    public void setPassword(String Password){password = Password;}

    public LoginDTO(String Username, String Password)
    {
        username = Username;
        password = Password;
    }

    public LoginDTO() { }

    public Account convert(){
        return new Account(username, password);
    }

}