package com.example.downloadservice.controller;

import com.example.downloadservice.model.Account;
import com.example.downloadservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @GetMapping("/checkStatus")
    public String checkStatus() {
        return "Application is up and running";
    }
}
