package com.logikas.kratos.core.repository;

public interface RepositoryLocator {
  
  <T, I> Repository<T, I> get(Class<T> domainType);
}
