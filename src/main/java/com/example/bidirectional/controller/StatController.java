package com.example.bidirectional.controller;

import com.example.bidirectional.entity.stat.WorkflowVersionEntity;
import com.example.bidirectional.service.stat.SessionStatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class StatController {

    private final SessionStatisticsService service;

    public StatController(SessionStatisticsService service) {
        this.service = service;
    }

    @PostMapping("/session")
    public ResponseEntity<String> createSession() {
        WorkflowVersionEntity version = new WorkflowVersionEntity();
        version.setId(1L);
        version.setVersion(20L);
        version.setContent("Test Content");
        service.addSession(UUID.randomUUID().toString(), version);
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }
}
