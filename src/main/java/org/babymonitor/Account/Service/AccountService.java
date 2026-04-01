package org.babymonitor.Account.Service;

import org.babymonitor.Account.Model.Account;
import org.babymonitor.Account.repo.AccountRepo;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    private AccountRepo repository;

    public Account createAccount(Account account) {
        account.setPassword(hashpassword(account.getpassword()));
        return repository.save(account);
    }

    public String hashpassword(String password) {
        PasswordEncoder encoder = new Argon2PasswordEncoder(16, 32, 1, 1 << 14, 3);
        return encoder.encode(password);

    }
}
