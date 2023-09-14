package com.example.bidirectional.service.stat;

import com.example.bidirectional.dao.BaseDaoImpl;
import com.example.bidirectional.entity.stat.SessionAttributeEntity;
import com.example.bidirectional.entity.stat.SessionStatAttributeEntity;
import com.example.bidirectional.entity.stat.SessionStatisticsEntity;
import com.example.bidirectional.entity.stat.WorkflowVersionEntity;
import com.example.bidirectional.repository.stat.SessionAttributeRepository;
import com.example.bidirectional.repository.stat.SessionStatisticsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SessionStatisticsServiceImpl extends BaseDaoImpl<SessionStatisticsEntity, String> implements SessionStatisticsService{

    private final SessionAttributeRepository sessionAttributeRepository;
    private final SessionStatisticsRepository sessionStatisticsRepository;

    public SessionStatisticsServiceImpl(SessionAttributeRepository sessionAttributeRepository,
                                        SessionStatisticsRepository sessionStatisticsRepository) {
        this.sessionAttributeRepository = sessionAttributeRepository;
        this.sessionStatisticsRepository = sessionStatisticsRepository;
    }

    @Override
    public void addSession(String sessionId, WorkflowVersionEntity workflowVersionEntity) {
        Optional<SessionAttributeEntity> startAttrib = sessionAttributeRepository.findById(1L);
        Optional<SessionAttributeEntity> activeAttrib = sessionAttributeRepository.findById(2L);

        SessionStatisticsEntity sessionStatistics = new SessionStatisticsEntity(sessionId);
        sessionStatistics.addAttribute(startAttrib.get(), 1);
        sessionStatistics.addAttribute(activeAttrib.get(), 1);

        super.create(sessionStatistics);
//        sessionStatisticsRepository.save(sessionStatistics);
    }

    @Override
    protected Class<SessionStatisticsEntity> getEntityClass() {
        return null;
    }
}
