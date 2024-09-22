package com.example.downloadservice.controller;

import com.example.downloadservice.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DownloadController {
    @Autowired
    private DownloadService downloadService;

    @GetMapping("/sendRecords")
    public String sendRecords(@RequestParam int count) {
        downloadService.sendRecords(count);
        return "Records sent: " + count;
    }
}
