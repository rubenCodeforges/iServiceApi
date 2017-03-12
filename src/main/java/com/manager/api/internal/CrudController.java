package com.manager.api.internal;

import java.util.List;

public interface CrudController <T> {
    public List<T> getAll();
    public T findOne(String id);
    public void create(T t);
    public void update(T t);
    public void delete(String id);
}
