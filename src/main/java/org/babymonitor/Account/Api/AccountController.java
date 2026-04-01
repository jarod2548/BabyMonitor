package org.babymonitor.Account.Api;

import org.babymonitor.Account.Model.Account;
import org.babymonitor.Account.Model.AccountDTO;
import org.babymonitor.Account.Service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService service;

    @PostMapping // dto
    public ResponseEntity<String> CreateAccount(@RequestBody @Valid AccountDTO account) {
        Account savedAccount = service.createAccount(account.convert());

        if (savedAccount != null) {
            return ResponseEntity.status(201).body("Account created successfully");
        } else {
            return ResponseEntity.status(500).body("Failed to create account");
        }
    }

}
