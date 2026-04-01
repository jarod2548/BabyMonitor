package org.babymonitor.Account.Service;

import java.util.Optional;

import org.babymonitor.Account.DTO.LoginDTO;
import org.babymonitor.Account.Model.Account;
import org.babymonitor.Account.Repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AccountRepository accountRepository;

    public LoginService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account login(Account model) {
        Account account = accountRepository.findByUsername(model.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!account.getPassword().equals(model.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return account;
    }
}