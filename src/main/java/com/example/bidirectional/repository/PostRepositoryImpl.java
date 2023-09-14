package com.example.bidirectional.repository;

import com.example.bidirectional.entity.Tag;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl extends BaseRepo<Tag, Long> {

    @PersistenceContext
    protected EntityManager entityManager;

    public Tag getTag(Long id) {
        TypedQuery<Tag> tag = entityManager.createNamedQuery(Tag.QUERY_GET_TAG_ATTRIBUTE_BY_ID, Tag.class)
                .setParameter("id", id);
        return super.getSingleResultOrNull(tag);
    }

}
