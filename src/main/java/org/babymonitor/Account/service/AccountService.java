package org.babymonitor.Account.service;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.babymonitor.Account.model.Account;
import org.babymonitor.Account.repository.AccountRepository;

public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository accountRepository) {
        this.repository = accountRepository;
    }

    public Account createAccount(Account account) {
        account.setPassword(hashpassword(account.getPassword()));
        return repository.save(account);
    }

    public String hashpassword(String password) {
        PasswordEncoder encoder = new Argon2PasswordEncoder(16, 32, 1, 1 << 14, 3);
        return encoder.encode(password);

    }
}
