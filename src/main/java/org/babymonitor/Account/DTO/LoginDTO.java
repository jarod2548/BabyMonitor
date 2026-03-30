package org.babymonitor.Account.DTO;

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
}