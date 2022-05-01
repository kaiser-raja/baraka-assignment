
package com.baraka.assignment.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "international-client", url = "localhost:8070")
public interface InternationalTransferService {

    @PostMapping(path = "/accounts/transfer")
    String transferToAccount(String IBAN, Double transferAmount);
}

