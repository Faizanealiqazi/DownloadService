package com.example.downloadservice.utils.utils;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class NodeIdProvider {
    @Getter
    private static final String nodeId = System.getenv("NODE_ID") != null ? System.getenv("NODE_ID") : "local-download-service-node-1";
}