package org.babymonitor.Account.Service;

import org.babymonitor.Account.Model.Account;
import org.babymonitor.Account.repo.AccountRepo;

public class AccountService {

    private AccountRepo repository;

    public Account createAccount(Account account) {
        return repository.save(account);
    }
}
