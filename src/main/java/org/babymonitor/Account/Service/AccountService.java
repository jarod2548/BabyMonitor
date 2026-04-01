package org.babymonitor.Account.Service;

import org.babymonitor.Account.Model.Account;
import org.babymonitor.Account.repo.AccountRepo;
import org.springframework.stereotype.Service;


@Service
public class AccountService {

    private AccountRepo repository;

    public AccountService (AccountRepo Repo){
        repository = Repo;
    }

    public Account createAccount(Account account) {
        return repository.save(account);
    }
}
