package com.logikas.kratos.system.ioc;

import com.logikas.kratos.system.service.UserService;
import com.logikas.kratos.system.service.impl.UserServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class SystemModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new SystemRepositoryModule());
    bind(UserService.class).to(UserServiceImpl.class).in(Singleton.class);    
  }
}
