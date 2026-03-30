// ==========DTO============//

// =========DBO/Entity======//
@Entity
@Table(name = "account")
public class Account {

    @Id
    private Long id;

    private String username;

    private String email;

    private String password;

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

}
