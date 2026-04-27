package org.babymonitor.Account.model;
import jakarta.validation.constraints.*;

public class LoginDTO {
   @Size(min = 1, max = 255, message = "Email must be between 1 and 255 characters.")
   @NotBlank(message = "Email cannot be blank")
   @Email(message = "Please provide a valid email address.")
    private String email;

   @NotBlank(message = "Password cannot be blank")
   @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters.")
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


    
    public Account convert(){
        return new Account(email, password);
    }
}
