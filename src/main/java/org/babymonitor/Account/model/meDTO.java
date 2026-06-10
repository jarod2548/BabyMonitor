package org.babymonitor.Account.model;

public class meDTO {
    private String username;
    private String email;
    private String role;

    public meDTO(Account account) {
        username = account.getUsername();
        email = account.getEmail();
        role = account.getRole();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
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

    public void setEmail(String email) {
        this.email = email;
    }
}
