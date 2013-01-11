package com.logikas.common.repository;

import java.io.Serializable;

public interface Repository<T, ID extends Serializable> {

  long count();

  T find(ID id);

  <S extends T> S save(S entity);

  void delete(T entity);
  
  void softDelete(T entity);

  Iterable<T> findAll(int offset, int limit);

  Iterable<T> findAll(Iterable<ID> ids);
}
