package com.logikas.kratos.core.repository.impl;

import com.logikas.kratos.core.repository.Repository;
import com.logikas.kratos.core.repository.RepositoryLocator;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

public class RepositoryLocatorImpl implements RepositoryLocator {

  private final Map<Class<?>, Provider<Repository<?, ?>>> repositoryMap;
    
  @Inject
  RepositoryLocatorImpl(Map<Class<?>, Provider<Repository<?, ?>>> repositoryMap) {
    this.repositoryMap = repositoryMap;
  }
  
  @SuppressWarnings("unchecked")
  @Override
  public <T, I> Repository<T, I> get(Class<T> domainType) {
    return (Repository<T, I>) repositoryMap.get(domainType);
  }
}
