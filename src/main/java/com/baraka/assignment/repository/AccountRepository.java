package com.baraka.assignment.repository;

import com.baraka.assignment.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    void deleteAccountByNumber(String number);

    Account findAccountByNumber(String number);
}
