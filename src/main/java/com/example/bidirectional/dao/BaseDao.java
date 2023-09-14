package com.example.bidirectional.dao;

import java.util.Collection;

public interface BaseDao<T, PK> {
    /**
     * Flushes changes to database. (This will not commit until transaction completes)
     */
    void flush();

    /**
     * Removes object from session.
     *
     * @param t to be evict from the session.
     */
    void detach(T t);

    /**
     * Merge changes to session.
     *
     * @param t Entity instance to be merged.
     * @return merged object.
     */
    T merge(T t);

    /**
     * Persists a new entity instance.
     *
     * @param t
     * @return
     */
    T create(T t);

    /**
     * Retrieves entity by given id.
     *
     * @param id
     * @return
     */
    T read(PK id);

    /**
     * Persists collection of entity instances.
     * @param t
     */
    void create(Collection<T> t);

    /**
     * removes a given entity instance.
     *
     * @param t
     * @return
     */
    void remove(T t);

    /**
     * refreshes a given entity instance.
     *
     * @param t
     */
    void refresh(T t);
}
