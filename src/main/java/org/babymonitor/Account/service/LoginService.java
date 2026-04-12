package org.babymonitor.Account.service;

import org.babymonitor.Account.model.LoginDTO;
import org.babymonitor.Account.model.Account;
import org.babymonitor.Account.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AccountRepository repository;

    public LoginService(AccountRepository accountRepository) {
        this.repository = accountRepository;
    }

    public Account login(Account model) {
        Account account = repository.findByUsername(model.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!account.getPassword().equals(model.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return account;
    }
}
