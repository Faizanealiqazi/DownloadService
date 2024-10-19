package com.example.downloadservice.service;

import com.example.downloadservice.config.RabbitConfig;
import com.example.downloadservice.model.Account;
import com.example.downloadservice.utils.annotation.Logging;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Logging
public class MessageSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    // general function
    public void sendMessage(String message){
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, message);
    }

    // ACCOUNT specific
    public void sendMessage(List<Account> accounts) {
        rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, accounts);
    }
}
