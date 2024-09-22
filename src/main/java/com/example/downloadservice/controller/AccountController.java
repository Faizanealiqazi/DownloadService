package com.example.downloadservice.controller;

import com.example.downloadservice.model.Account;
import com.example.downloadservice.service.AccountService;
import com.example.downloadservice.service.DownloadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    private final DownloadService downloadService;

    public AccountController(AccountService accountService, DownloadService downloadService) {
        this.accountService = accountService;
        this.downloadService = downloadService;
    }

    @GetMapping("/getAllAccounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }
    @GetMapping("/startDownload")
    public String startDownload() {
        downloadService.getAllAccounts();
        return "Download process started!";
    }

    @GetMapping("/checkStatus")
    public String checkStatus() {
        return "Application is up and running";
    }
}
