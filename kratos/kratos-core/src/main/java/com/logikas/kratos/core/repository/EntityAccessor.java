package com.logikas.kratos.core.repository;

public interface EntityAccessor<T, I> {

  I getId(T entity);

  Object getVersion(T entity);
}
