package com.logikas.kratos.core.repository;

import java.io.Serializable;

public interface Repository<T, ID extends Serializable> {
  
  T find(ID id);

  T save(T entity);

  Iterable<T> findAll();

  Long count();

  void delete(T entity);

  boolean exists(ID primaryKey);
}
