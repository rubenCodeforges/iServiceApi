package com.manager.api.internal;

import java.util.List;

public interface CrudController <T> {
    List<T> getAll();
    T findOne(String id);
    void create(T t);
    void update(T t);
    void delete(String id);
}
