package com.example.bidirectional.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseDeletableEntity extends BaseEntity {
    private static final long serialVersionUID = -4768497979423073176L;

    private Boolean deleted;

    public BaseDeletableEntity() {
        deleted = Boolean.FALSE;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(final Boolean deleted) {
        this.deleted = deleted;
    }
}
