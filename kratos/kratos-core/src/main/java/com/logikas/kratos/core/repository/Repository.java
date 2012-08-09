package com.logikas.kratos.core.repository;


public interface Repository<T, I> {
  
  T find(I id);

  I getId(T entity);

  Object getVersion(T entity);

  Class<T> getDomainType();
  
  Class<I> getIdType();

  T create();
}
