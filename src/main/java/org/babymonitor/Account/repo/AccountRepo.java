package org.babymonitor.Account.repo;

import org.babymonitor.Account.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
