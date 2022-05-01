
package com.baraka.assignment.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "third-party-bank-client", url = "localhost:8060")
public interface ThirdPartyBankService {

    @PostMapping(path = "/accounts/transfer")
    String transferToAccount(String accountNumber, Double transferAmount);
}

