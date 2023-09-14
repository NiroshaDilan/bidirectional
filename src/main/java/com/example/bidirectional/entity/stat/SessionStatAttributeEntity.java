package com.example.bidirectional.entity.stat;

import jakarta.persistence.*;

@Entity
@Table(name = "session_stat_attribute")
public class SessionStatAttributeEntity {

    @EmbeddedId
    private SessionAttributeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sessionStatisticsId")
    private SessionStatisticsEntity sessionStatistics;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sessionAttributeId")
    private SessionAttributeEntity sessionAttribute;

    private Integer count;

    public SessionAttributeId getId() {
        return id;
    }

    public void setId(SessionAttributeId id) {
        this.id = id;
    }

    public SessionStatAttributeEntity() {}

    public SessionStatAttributeEntity(SessionStatisticsEntity sessionStatistics,
                                      SessionAttributeEntity sessionAttribute,
                                      Integer count) {
        this.sessionStatistics = sessionStatistics;
        this.sessionAttribute = sessionAttribute;
        this.count = count;
        this.id = new SessionAttributeId(sessionStatistics.getSessionId(), sessionAttribute.getId());
    }

    public SessionStatisticsEntity getSessionStatistics() {
        return sessionStatistics;
    }

    public void setSessionStatistics(SessionStatisticsEntity sessionStatistics) {
        this.sessionStatistics = sessionStatistics;
    }

    public SessionAttributeEntity getSessionAttribute() {
        return sessionAttribute;
    }

    public void setSessionAttribute(SessionAttributeEntity sessionAttribute) {
        this.sessionAttribute = sessionAttribute;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
