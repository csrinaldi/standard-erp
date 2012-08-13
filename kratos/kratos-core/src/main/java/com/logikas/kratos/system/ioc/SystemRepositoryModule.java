package com.logikas.kratos.system.ioc;

import com.logikas.kratos.commons.ioc.RepositoryModule;
import com.logikas.kratos.system.repository.UserRepository;
import com.logikas.kratos.system.repository.impl.UserRepositoryImpl;

import javax.inject.Singleton;

public class SystemRepositoryModule extends RepositoryModule {

  @Override
  protected void configureRepositories() {
    bindRepository(UserRepository.class).to(UserRepositoryImpl.class).in(Singleton.class);
  }
}
