package org.babymonitor.Account.api;

import org.babymonitor.Account.model.Account;
import org.babymonitor.Account.model.AccountDTO;
import org.babymonitor.Account.model.LoginDTO;
import org.babymonitor.Account.model.LoginResponseDTO;
import org.babymonitor.Account.service.AccountService;
import org.babymonitor.Account.service.LoginService;
import org.babymonitor.config.CookieService;
import org.babymonitor.config.JWTService;
import org.babymonitor.config.UserPrincipal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

    @Mock
    private AccountService accountService;

    @Mock
    private LoginService loginService;

    @Mock
    private JWTService jwtService;

    @Mock
    private CookieService cookieService;

    @InjectMocks
    private AccountController accountController;

    @Test
    void createAccount_returns201_whenAccountCreated() {
        AccountDTO dto = new AccountDTO("Amer", "test@mail.com", "password123", "USER");
        Account saved = new Account("Amer", "test@mail.com", "hashedPassword", "USER");

        when(accountService.createAccount(any(Account.class))).thenReturn(saved);

        ResponseEntity<String> response = accountController.CreateAccount(dto);

        assertEquals(201, response.getStatusCode().value());
        assertEquals("Account created successfully", response.getBody());
    }

    @Test
    void createAccount_returns500_whenAccountCreationFails() {
        AccountDTO dto = new AccountDTO("Amer", "test@mail.com", "password123", "USER");

        when(accountService.createAccount(any(Account.class))).thenReturn(null);

        ResponseEntity<String> response = accountController.CreateAccount(dto);

        assertEquals(500, response.getStatusCode().value());
        assertEquals("Failed to create account", response.getBody());
    }

    @Test
    void login_returns200_andSetCookie_whenSuccessful() {
        LoginDTO loginDTO = new LoginDTO("test@mail.com", "password123");
        Account account = new Account("Amer", "test@mail.com", "hashedPassword", "USER");
        String token = "mocked-jwt-token";
    
        ResponseCookie cookie = ResponseCookie.from("jwt", token)
                .httpOnly(true)
                .path("/")
                .build();
    
        when(loginService.login(any(Account.class))).thenReturn(account);
        when(jwtService.generateToken(account)).thenReturn(token);
        when(cookieService.createJwtCookie(token)).thenReturn(cookie);
    
        ResponseEntity<String> response = accountController.login(loginDTO);
    
        assertEquals(200, response.getStatusCode().value());
        assertEquals("Login Successful", response.getBody());
        assertEquals(cookie.toString(), response.getHeaders().getFirst("Set-Cookie"));
    }

    @Test
    void authorize_returns401_whenUserIsNull() {
        ResponseEntity<LoginResponseDTO> response = accountController.authorize(null);

        assertEquals(401, response.getStatusCode().value());
        assertNull(response.getBody());
    }

    @Test
    void authorize_returns200_whenUserExists() {
        UserPrincipal user = new UserPrincipal(1L, "Amer", "USER");

        ResponseEntity<LoginResponseDTO> response = accountController.authorize(user);

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        assertEquals("Amer", response.getBody().getUsername());
        assertEquals("USER", response.getBody().getRole());
    }
}