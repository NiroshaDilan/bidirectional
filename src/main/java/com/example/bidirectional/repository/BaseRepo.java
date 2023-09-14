package com.example.bidirectional.repository;

import jakarta.persistence.TypedQuery;

import java.util.List;

public class BaseRepo<T, PK> {
    protected T getSingleResultOrNull(final TypedQuery<T> q) {
        List<T> list = q.getResultList();
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}
