package com.logikas.kratos.system.ioc;

import com.logikas.kratos.system.repository.UserRepository;
import com.logikas.kratos.system.repository.impl.UserRepositoryImpl;
import com.logikas.kratos.system.service.UserService;
import com.logikas.kratos.system.service.impl.UserServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class SystemModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(UserRepository.class).to(UserRepositoryImpl.class).in(Singleton.class);
    bind(UserService.class).to(UserServiceImpl.class).in(Singleton.class);    
  }
}
