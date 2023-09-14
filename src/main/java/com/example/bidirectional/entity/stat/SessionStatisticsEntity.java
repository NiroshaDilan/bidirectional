package com.example.bidirectional.entity.stat;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "session_statistics")
public class SessionStatisticsEntity {
    public static final String QUERY_GET_SESSION_STAT_BY_SESSION =
            "SessionStatisticsEntity.getSessionStatBySession";

    @Column(unique = true)
    @Id
    private String sessionId;

    @OneToMany(
            mappedBy = "sessionStatistics",
            cascade = CascadeType.ALL)
//    private Set<SessionStatAttributeEntity> sessionStatAttributes = new HashSet<>();
    private List<SessionStatAttributeEntity> sessionStatAttributes = new ArrayList<>();


    public SessionStatisticsEntity() {}

    public SessionStatisticsEntity(String sessionId) {
        this.sessionId = sessionId;
    }


    public void addAttribute(SessionAttributeEntity sessionAttribute, Integer count) {
        SessionStatAttributeEntity sessionStatAttribute =
                new SessionStatAttributeEntity(this, sessionAttribute, count);
        sessionStatAttributes.add(sessionStatAttribute);
        sessionAttribute.getSessionStatAttributes().add(sessionStatAttribute);
    }

    public void removeAttribute(SessionAttributeEntity sessionAttribute) {
        for (Iterator<SessionStatAttributeEntity> iterator = sessionStatAttributes.iterator();
             iterator.hasNext();) {
            SessionStatAttributeEntity sessionStatAttribute = iterator.next();

            if (sessionStatAttribute.getSessionStatistics().equals(this) &&
                    sessionStatAttribute.getSessionAttribute().equals(sessionAttribute)) {
                iterator.remove();
                sessionStatAttribute.getSessionAttribute()
                        .getSessionStatAttributes()
                        .remove(sessionStatAttribute);
                sessionStatAttribute.setSessionStatistics(null);
                sessionStatAttribute.setSessionAttribute(null);
            }
        }
    }


    public List<SessionStatAttributeEntity> getSessionStatAttributes() {
        return sessionStatAttributes;
    }

    public void setSessionStatAttributes(List<SessionStatAttributeEntity> sessionStatAttributes) {
        this.sessionStatAttributes = sessionStatAttributes;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SessionStatisticsEntity that = (SessionStatisticsEntity) o;
        return Objects.equals(sessionId, that.sessionId) &&
                Objects.equals(sessionStatAttributes, that.sessionStatAttributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionId, sessionStatAttributes);
    }
}
