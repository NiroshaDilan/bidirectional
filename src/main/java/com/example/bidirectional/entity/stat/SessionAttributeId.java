package com.example.bidirectional.entity.stat;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SessionAttributeId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "session_statistics_id")
    private String sessionStatisticsId;

    @Column(name = "session_attribute_id")
    private Long sessionAttributeId;

    public SessionAttributeId() {
    }

    public SessionAttributeId(String sessionStatisticsId, Long sessionAttributeId) {
        this.sessionStatisticsId = sessionStatisticsId;
        this.sessionAttributeId = sessionAttributeId;
    }

    public String getSessionStatisticsId() {
        return sessionStatisticsId;
    }

    public void setSessionStatisticsId(String sessionStatisticsId) {
        this.sessionStatisticsId = sessionStatisticsId;
    }

    public Long getSessionAttributeId() {
        return sessionAttributeId;
    }

    public void setSessionAttributeId(Long sessionAttributeId) {
        this.sessionAttributeId = sessionAttributeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        SessionAttributeId that = (SessionAttributeId) o;
        return Objects.equals(sessionStatisticsId, that.sessionStatisticsId) &&
                Objects.equals(sessionAttributeId, that.sessionAttributeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionStatisticsId, sessionAttributeId);
    }
}
