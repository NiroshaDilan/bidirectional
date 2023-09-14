package com.example.bidirectional.entity.stat;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NamedQueries(value = {
        @NamedQuery(name = SessionAttributeEntity.QUERY_GET_ALL,
                query = "SELECT a FROM SessionAttributeEntity  a"),
        @NamedQuery(name = SessionAttributeEntity.QUERY_GET_ATTRIBUTE_BY_ID,
                query = "SELECT a FROM SessionAttributeEntity a WHERE a.id = :id")
})
@Entity
@Table(name = "session_attribute")
public class SessionAttributeEntity {

    public static final String QUERY_GET_ALL = "SessionAttribute.getAll";
    public static final String QUERY_GET_ATTRIBUTE_BY_ID = "SessionAttribute.getAttributeById";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(
            mappedBy = "sessionAttribute",
            cascade = CascadeType.ALL)
//    private Set<SessionStatAttributeEntity> sessionStatAttributes = new HashSet<>();
    private List<SessionStatAttributeEntity> sessionStatAttributes = new ArrayList<>();

    @Column(name = "name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SessionStatAttributeEntity> getSessionStatAttributes() {
        return sessionStatAttributes;
    }

    public void setSessionStatAttributes(List<SessionStatAttributeEntity> sessionStatAttributes) {
        this.sessionStatAttributes = sessionStatAttributes;
    }

//    public Set<SessionStatAttributeEntity> getSessionStatAttributes() {
//        return sessionStatAttributes;
//    }
//
//    public void setSessionStatAttributes(Set<SessionStatAttributeEntity> sessionStatAttributes) {
//        this.sessionStatAttributes = sessionStatAttributes;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
