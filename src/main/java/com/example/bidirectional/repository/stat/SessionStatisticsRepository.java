package com.example.bidirectional.repository.stat;

import com.example.bidirectional.entity.stat.SessionStatisticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionStatisticsRepository extends JpaRepository<SessionStatisticsEntity, String> {
}
