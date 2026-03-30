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

    public String login(LoginDTO loginDTO) {
        Optional<Account> accountOptional = accountRepository.findByUsername(loginDTO.getUsername());

        if (accountOptional.isEmpty()) {
            return "Gebruiker niet gevonden";
        }

        Account account = accountOptional.get();

        if (!account.GetPassword().equals(loginDTO.getPassword())) {
            return "Wachtwoord is onjuist";
        }

        return "Login gelukt";
    }
}