package com.example.bidirectional.dao;

import com.example.bidirectional.entity.BaseDeletableEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

public abstract class BaseDaoImpl<T, PK> implements BaseDao<T, PK> {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void flush() {
        entityManager.flush();
    }

    @Override
    public void detach(final T t) {
        entityManager.detach(t);
    }

    @Override
    public T merge(final T t) {
        try {
            return entityManager.merge(t);
        } catch (OptimisticLockException e) {
            if (!isDeletedObject(t)) {
                throw e;
            }
        }
        return null;
    }

    @Override
    public T create(final T t) {
        entityManager.persist(t);

        return t;
    }

    @Override
    public void create(final Collection<T> t) {
        if (t != null) {
            for (T obj : t) {
                entityManager.persist(obj);
            }
        }
    }

    @Override
    public void remove(final T t) {
        entityManager.remove(t);
    }

    @Override
    public void refresh(final T t) {
        entityManager.refresh(t);
    }

    @Override
    public T read(final PK id) {
        if (id == null) {
            throw new IllegalArgumentException("id can't be null");
        }
        return entityManager.find(getEntityClass(), id);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * We need this as Query.getSingleResult() throws a friggin exception if no results are found!
     *
     * @param <T>	The type
     * @param q		Query
     * @return		The single result, or null
     */
    protected T getSingleResultOrNull(final TypedQuery<T> q) {
        List<T> list = q.getResultList();
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    /**
     * Utility method to extract and convert a Long value e.g. an id or count from a hibernate HQL query.
     *
     * @param object the query object from a query.getSingleResult()
     * @return converted Long value depending on the underlying database.
     */
    protected Long getLongValue(final Object object) {
        Long value = null;
        if (object instanceof BigDecimal) {
            value = ((BigDecimal) object).longValue();
        } else if (object instanceof Integer) {
            value = ((Integer) object).longValue();
        } else if (object instanceof Long) {
            value = ((Long) object).longValue();
        } else if (object instanceof BigInteger) {
            value = ((BigInteger) object).longValue();
        }
        return value;
    }

    protected boolean isDeletedObject(final T t) {
        if (t instanceof BaseDeletableEntity) {
            BaseDeletableEntity entity = (BaseDeletableEntity) getEntityManager().find((getEntityClass()),
                    ((BaseDeletableEntity) t).getId());
            if (entity != null && entity.getDeleted()) {
                throw new RuntimeException("Object with the ID <" + entity.getId() + "> is already bieng deleted");
            }
        }
        return false;
    }

    /**
     * Returns the specialized Class type of the Dao implementation.
     *
     * @return T corresponding Entity class
     */
    protected abstract Class<T> getEntityClass();
}
