package org.babymonitor.Account.model;

import jakarta.validation.constraints.*;

// =========DTO=============//
public class PasswordDTO {

    @NotNull
    private String oldpassword;

    @NotNull
    private String newpassword;

    // standard constructor
    public PasswordDTO(String oldpswrd, String newpswrd) {
        oldpassword = oldpswrd;
        newpassword = newpswrd;
    }

    public void setOldpassword(String oldpswrd) {
        oldpassword = oldpswrd;
    }

    public void setNewpassword(String newpswrd) {
        newpassword = newpswrd;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }
}
