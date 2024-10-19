package com.example.downloadservice.service;

import com.example.downloadservice.model.Account;
import com.example.downloadservice.repository.AccountRepository;
import com.example.downloadservice.utils.annotation.Logging;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Logging
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }
}
