package com.logikas.kratos.commons.ioc;

import com.logikas.kratos.core.repository.Repository;

import javax.inject.Inject;
import javax.inject.Provider;

class RepositoryProvider<T, I, R extends Repository<T, I>> implements Provider<Repository<T, I>> {

  private final Provider<R> repositoryProvider;
  
  @Inject
  RepositoryProvider(Provider<R> repoProvider) {
    this.repositoryProvider = repoProvider;
  }
  
  @Override
  public Repository<T, I> get() {
    return repositoryProvider.get();
  }
}
