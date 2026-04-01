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

    public String login(LoginDTO loginDTO) {
        Account account = repository.findByUsername(loginDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("user not found"));

        if (!account.getPassword().equals(loginDTO.getPassword())) {
            return "Wachtwoord is onjuist";
        }

        return "Login gelukt";
    }
}
