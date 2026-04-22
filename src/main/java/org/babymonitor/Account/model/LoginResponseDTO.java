package org.babymonitor.Account.model;

import org.babymonitor.Security.UserPrincipal;

public class LoginResponseDTO {
    private String username;
    private String role;

    public LoginResponseDTO(Account account){
        username = account.getUsername();
        role = account.getRole();
    }
    public LoginResponseDTO(UserPrincipal user) {
        this.username = user.getUsername();
        this.role = user.getRole();
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
