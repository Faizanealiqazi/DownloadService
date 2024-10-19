package com.example.downloadservice.service;

import com.example.downloadservice.model.Account;
import com.example.downloadservice.repository.AccountRepository;
import com.example.downloadservice.utils.annotation.Logging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
@Logging
public class DownloadService {
    @Autowired
    private MessageSender messageSender;
    @Autowired
    private AccountRepository accountRepository;
    private static final Logger logger = LoggerFactory.getLogger(DownloadService.class);

    public void sendRecords(int recordCount) {
        logger.info("sendRecords(...) :: recordCount {}", recordCount);
        IntStream.range(0, recordCount).forEach(i -> {
            String message = "Record " + i;
            messageSender.sendMessage(message);
        });
    }

    public void getAllAccounts() {
        List<Account> allAccounts = accountRepository.findAll();
        int batchSize = 1000; //TODO: set a dynamic batch size
        for (int i = 0; i < allAccounts.size(); i += batchSize) {
            List<Account> batch = allAccounts.subList(i, Math.min(i + batchSize, allAccounts.size()));
            messageSender.sendMessage(batch);
        }
    }
}
