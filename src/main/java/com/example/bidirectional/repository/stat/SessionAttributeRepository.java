package com.example.bidirectional.repository.stat;

import com.example.bidirectional.entity.stat.SessionAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionAttributeRepository extends JpaRepository<SessionAttributeEntity, Long> {
}
