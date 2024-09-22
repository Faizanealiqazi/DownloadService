package com.example.downloadservice.service;

import com.example.downloadservice.model.Account;
import com.example.downloadservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class DownloadService {
    @Autowired
    private MessageSender messageSender;
    @Autowired
    private AccountRepository accountRepository;

    public void sendRecords(int recordCount) {
        IntStream.range(0, recordCount).forEach(i -> {
            String message = "Record " + i;
            messageSender.sendMessage(message);
        });
    }

    public void getAllAccounts() {
        List<Account> allAccounts = accountRepository.findAll();

        // Send data to RabbitMQ in manageable chunks
        int batchSize = 1000; // Define a suitable batch size based on memory and performance
        for (int i = 0; i < allAccounts.size(); i += batchSize) {
            List<Account> batch = allAccounts.subList(i, Math.min(i + batchSize, allAccounts.size()));
            messageSender.sendMessage(batch);
        }
    }
}
