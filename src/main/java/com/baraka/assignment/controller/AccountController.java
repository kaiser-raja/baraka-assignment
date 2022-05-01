package com.baraka.assignment.controller;

import com.baraka.assignment.domain.Account;
import com.baraka.assignment.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Account createAccount(@RequestBody final Account accountCreationRequest) {
        return accountService.createAccount(accountCreationRequest);
    }

    @DeleteMapping(path = "/delete/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteAccount(@PathVariable String number) {
        return accountService.deleteAccount(number);
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping(path = "/{number}/balance", produces = MediaType.APPLICATION_JSON_VALUE)
    public Double getBalance(@PathVariable String number) {
        return accountService.getBalance(number);
    }

    @PutMapping(path = "/{number}/deposit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Account deposit(@PathVariable String number, @RequestParam Double amount) {
        return accountService.deposit(number, amount);
    }

    @PutMapping(path = "/{number}/withdraw", produces = MediaType.APPLICATION_JSON_VALUE)
    public Account withdraw(@PathVariable String number, @RequestParam Double amount) {
        return accountService.withdraw(number, amount);
    }

    @PutMapping(path = "/local/transfer", produces = MediaType.APPLICATION_JSON_VALUE)
    public String transferLocally(@RequestParam String fromAccount, @RequestParam String toAccount,
                                  @RequestParam Double amount) {
        return accountService.transferToLocalAccount(fromAccount, toAccount, amount);
    }

    @PutMapping(path = "/international/transfer", produces = MediaType.APPLICATION_JSON_VALUE)
    public String transferInternationally(@RequestParam String fromAccount, @RequestParam String IBAN,
                                          @RequestParam Double amount) {
        return accountService.transferToLocalAccount(fromAccount, IBAN, amount);
    }
}
