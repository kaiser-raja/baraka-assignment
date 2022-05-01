package com.baraka.assignment.request;

import com.baraka.assignment.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationRequest {

    private final AccountRepository accountRepository;


    public AccountCreationRequest(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    
}
