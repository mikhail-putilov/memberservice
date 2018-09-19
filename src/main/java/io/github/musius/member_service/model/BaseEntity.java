package io.github.musius.member_service.model;

import java.io.Serializable;

public class BaseEntity<T> implements Serializable {
    protected T id;

    @SuppressWarnings("WeakerAccess")
    protected BaseEntity(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
