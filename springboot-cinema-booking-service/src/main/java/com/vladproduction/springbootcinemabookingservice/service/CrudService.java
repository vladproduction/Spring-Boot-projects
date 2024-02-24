package com.vladproduction.springbootcinemabookingservice.service;

public interface CrudService<T> {

    T getById(long id);

    T create(T entity);

    T updateById(long id, T entity);

    boolean deleteById(long id);
}
