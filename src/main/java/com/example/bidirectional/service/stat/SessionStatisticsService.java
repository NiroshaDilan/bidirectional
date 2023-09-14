package com.example.bidirectional.service.stat;

import com.example.bidirectional.entity.stat.WorkflowVersionEntity;

public interface SessionStatisticsService {
    void addSession(String sessionId, WorkflowVersionEntity workflowVersionEntity);
}
