package com.logikas.kratos.core.repository;

import java.io.Serializable;

public interface Repository<T, ID extends Serializable> extends EntityFinder<T, ID> {

  T save(T entity);

  Iterable<T> findAll();

  Long count();

  void delete(T entity);

  boolean exists(ID primaryKey);
}
