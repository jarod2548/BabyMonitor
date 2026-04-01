package org.babymonitor.Account.api;

import org.babymonitor.Account.model.*;
import org.babymonitor.Account.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;
    private final LoginService loginService;

    public AccountController(AccountService accountservice, LoginService loginservice) {
        this.accountService = accountservice;
        this.loginService = loginservice;
    }

    @PostMapping
    public ResponseEntity<String> CreateAccount(@RequestBody @Valid AccountDTO account) {
        Account savedAccount = accountService.createAccount(account.convert());

        if (savedAccount != null) {
            return ResponseEntity.status(201).body("Account created successfully");
        } else {
            return ResponseEntity.status(500).body("Failed to create account");
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }

}
