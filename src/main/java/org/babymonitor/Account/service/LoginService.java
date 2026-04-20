package org.babymonitor.Account.service;

import org.babymonitor.Account.model.LoginDTO;
import org.babymonitor.Account.model.Account;
import org.babymonitor.Account.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class LoginService {

    private final AccountRepository repository;
    private final PasswordEncoder encoder = new Argon2PasswordEncoder(16, 32, 1, 1 << 14, 3);

    public LoginService(AccountRepository accountRepository) {
        this.repository = accountRepository;
    }

    public Account login(Account model) {
        Account account = repository.findByEmail(model.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
       if (!encoder.matches(model.getPassword(), account.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return account;
    }
}