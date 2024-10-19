package com.example.downloadservice.controller;

import com.example.downloadservice.service.DownloadService;
import com.example.downloadservice.utils.annotation.Logging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Logging
public class DownloadController {
    @Autowired
    private DownloadService downloadService;
    private static final Logger logger = LoggerFactory.getLogger(DownloadController.class);

    @GetMapping("/sendRecords")
    public String sendRecords(@RequestParam int count) {
        logger.info("sendRecords(...) :: requested count {}", count);
        downloadService.sendRecords(count);
        return "Records sent: " + count;
    }
}
