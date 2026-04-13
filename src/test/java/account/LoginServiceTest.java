package org.babymonitor.Account.service;

import org.babymonitor.Account.model.Account;
import org.babymonitor.Account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

    @Mock
    private AccountRepository repository;

    @InjectMocks
    private LoginService loginService;

    private PasswordEncoder encoder;

    @BeforeEach
    void setUp() {
        encoder = new Argon2PasswordEncoder(16, 32, 1, 1 << 14, 3);
    }

    @Test
    void login_ShouldReturnAccount_WhenCredentialsAreCorrect() {
        String rawPassword = "secret123";
        String hashedPassword = encoder.encode(rawPassword);

        Account storedAccount = new Account("testuser", "test@mail.com", hashedPassword, "USER");

        Account loginInput = new Account();
        loginInput.setEmail("test@mail.com");
        loginInput.setPassword(rawPassword);

        when(repository.findByEmail("test@mail.com")).thenReturn(Optional.of(storedAccount));

        Account result = loginService.login(loginInput);

        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        assertEquals("test@mail.com", result.getEmail());
    }

    @Test
    void login_ShouldThrowException_WhenUserNotFound() {
        Account loginInput = new Account();
        loginInput.setEmail("nietgevonden@mail.com");
        loginInput.setPassword("secret123");

        when(repository.findByEmail("nietgevonden@mail.com")).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> loginService.login(loginInput));

        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void login_ShouldThrowException_WhenPasswordIsInvalid() {
        String hashedPassword = encoder.encode("correctPassword");

        Account storedAccount = new Account("testuser", "test@mail.com", hashedPassword, "USER");

        Account loginInput = new Account();
        loginInput.setEmail("test@mail.com");
        loginInput.setPassword("wrongPassword");

        when(repository.findByEmail("test@mail.com")).thenReturn(Optional.of(storedAccount));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> loginService.login(loginInput));

        assertEquals("Invalid password", exception.getMessage());
    }
}