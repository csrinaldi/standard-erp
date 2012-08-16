package com.logikas.kratos.core.repository;

public interface Repository<T, I> extends EntityFinder<T, I> {
  
  void save(T entity);
}
