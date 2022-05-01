package com.baraka.assignment.service;

import com.baraka.assignment.domain.Account;
import com.baraka.assignment.repository.AccountRepository;
import com.baraka.assignment.utils.CommonUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountService {

    private static final String ACCOUNT_CACHE = "account_cache";

    private final AccountRepository accountRepository;

    //private final ThirdPartyBankService thirdPartyBankService;

    //private final InternationalTransferService internationalTransferService;

    public AccountService(final AccountRepository accountRepository) {//, ThirdPartyBankService thirdPartyBankService,
                          //InternationalTransferService internationalTransferService) {
        this.accountRepository = accountRepository;
        //this.thirdPartyBankService = thirdPartyBankService;
        //this.internationalTransferService = internationalTransferService;
    }

    @CacheEvict(value = ACCOUNT_CACHE, allEntries = true)
    public Account createAccount(final Account accountCreationRequest) {
        String accountNumber = CommonUtils.generateAccountNumber();
        accountCreationRequest.setNumber(accountNumber);
        return accountRepository.save(accountCreationRequest);
    }

    @CacheEvict(value = ACCOUNT_CACHE, allEntries = true)
    public String deleteAccount(final String accountNumber) {
        accountRepository.deleteAccountByNumber(accountNumber);
        return "deleted";
    }

    @Cacheable(value = ACCOUNT_CACHE)
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Double getBalance(final String accountNumber) {
        Account account = accountRepository.findAccountByNumber(accountNumber);
        return account.getBalance();
    }

    @CacheEvict(value = ACCOUNT_CACHE, allEntries = true)
    public Account deposit(final String accountNumber, final Double depositAmount) {
        Account account = accountRepository.findAccountByNumber(accountNumber);
        Double currentAmount = account.getBalance();
        account.setBalance(currentAmount + depositAmount);
        return accountRepository.save(account);
    }

    @CacheEvict(value = ACCOUNT_CACHE, allEntries = true)
    public Account withdraw(final String accountNumber, final Double withdrawalAmount) {
        Account account = accountRepository.findAccountByNumber(accountNumber);
        Double currentAmount = account.getBalance();
        account.setBalance(currentAmount - withdrawalAmount);
        return accountRepository.save(account);
    }

    @CacheEvict(value = ACCOUNT_CACHE, allEntries = true)
    public String transferToLocalAccount(final String accountNumber, final String accountNumberToTransfer,
                                          final Double transferAmount) {
        Account fromAccount = accountRepository.findAccountByNumber(accountNumber);
        Account toAccount = accountRepository.findAccountByNumber(accountNumberToTransfer);
        Double fromBalance = fromAccount.getBalance();
        fromAccount.setBalance(fromBalance - transferAmount);
        Double toBalance = toAccount.getBalance();
        toAccount.setBalance(toBalance + transferAmount);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        return "transfer successful";
    }

    @CacheEvict(value = ACCOUNT_CACHE, allEntries = true)
    public String transferToThirdPartyBankAccount(final String accountNumber, final String accountNumberToTransfer,
                                         final Double transferAmount) {
        Account fromAccount = accountRepository.findAccountByNumber(accountNumber);
        Double fromBalance = fromAccount.getBalance();
        fromAccount.setBalance(fromBalance - transferAmount);
        accountRepository.save(fromAccount);
        //thirdPartyBankService.transferToAccount(accountNumberToTransfer, transferAmount);
        return "transfer successful";
    }

    @CacheEvict(value = ACCOUNT_CACHE, allEntries = true)
    public String transferToInternationalBankAccount(final String accountNumber, final String IBAN,
                                                  final Double transferAmount) {
        Account fromAccount = accountRepository.findAccountByNumber(accountNumber);
        Double fromBalance = fromAccount.getBalance();
        fromAccount.setBalance(fromBalance - transferAmount);
        accountRepository.save(fromAccount);
        //internationalTransferService.transferToAccount(IBAN, transferAmount);
        return "transfer successful";
    }
}
