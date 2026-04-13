package org.babymonitor.Account.service;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.babymonitor.Account.model.Account;
import org.babymonitor.Account.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository repository;
    private final PasswordEncoder encoder = new Argon2PasswordEncoder(16, 32, 1, 1 << 14, 3);

    public AccountService(AccountRepository accountRepository) {
        this.repository = accountRepository;
    }

    public Account createAccount(Account account) {
        account.setPassword(hashpassword(account.getPassword()));
        return repository.save(account);
    }

    public String hashpassword(String password) {
        return encoder.encode(password);

    }

    public Account findAccount(Long id) {
        Account account = repository.findById(id).orElseThrow(() -> new RuntimeException("account not found"));
        return account;
    }

    public Account changePassword(Account account, String oldpswrd, String newpswrd) {
        if (!encoder.matches(oldpswrd, account.getPassword())) {
            throw new IllegalArgumentException("Old password is incorrect");
        }

        account.setPassword(hashpassword(newpswrd));
        return repository.save(account);
    }
}
