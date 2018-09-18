package io.github.musius.member_service.model;

public class BaseEntity<T> {
    protected T id;

    public BaseEntity(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
