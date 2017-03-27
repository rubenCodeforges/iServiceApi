package com.manager.api.internal;

import java.util.Collection;

public interface CrudController <T> {
    Collection<T> getAll();

    T findById(Long id);
    void create(T t);
    void update(T t);
    void delete(Long id);
}
