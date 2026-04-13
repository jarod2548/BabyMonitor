package org.babymonitor.Account.service;

import org.babymonitor.Account.model.Account;
import org.babymonitor.Account.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository repository;

    @InjectMocks
    private AccountService accountService;

    @Test
    void createAccount_ShouldHashPasswordAndSaveAccount() {
        Account account = new Account("testuser", "test@mail.com", "password123", "USER");

        when(repository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Account result = accountService.createAccount(account);

        ArgumentCaptor<Account> captor = ArgumentCaptor.forClass(Account.class);
        verify(repository, times(1)).save(captor.capture());

        Account savedAccount = captor.getValue();

        assertNotNull(result);
        assertEquals("testuser", savedAccount.getUsername());
        assertEquals("test@mail.com", savedAccount.getEmail());
        assertEquals("USER", savedAccount.getRole());

        assertNotEquals("password123", savedAccount.getPassword());
        assertTrue(savedAccount.getPassword().startsWith("$argon2"));
    }

    @Test
    void hashpassword_ShouldReturnArgon2Hash() {
        String hashed = accountService.hashpassword("mijnWachtwoord");

        assertNotNull(hashed);
        assertNotEquals("mijnWachtwoord", hashed);
        assertTrue(hashed.startsWith("$argon2"));
    }
}