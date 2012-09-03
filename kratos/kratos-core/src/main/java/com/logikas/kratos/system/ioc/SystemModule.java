package com.logikas.kratos.system.ioc;

import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.repository.UserAvatarRepository;
import com.logikas.kratos.system.repository.UserRepository;
import com.logikas.kratos.system.repository.impl.UserAvatarRepositoryImpl;
import com.logikas.kratos.system.repository.impl.UserRepositoryImpl;
import com.logikas.kratos.system.service.UserAvatarService;
import com.logikas.kratos.system.service.UserService;
import com.logikas.kratos.system.service.impl.UserAvatarServiceImpl;
import com.logikas.kratos.system.service.impl.UserServiceImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.servlet.ServletScopes;

import java.util.Date;

public class SystemModule extends AbstractModule {

  @Override
  protected void configure() {

    bind(Date.class).toProvider(DateProvider.class);
    bind(User.class).toProvider(CurrentUserProvider.class).in(ServletScopes.SESSION);

    bind(UserAvatarRepository.class).to(UserAvatarRepositoryImpl.class).in(Singleton.class);
    bind(UserAvatarService.class).to(UserAvatarServiceImpl.class).in(Singleton.class);

    bind(UserRepository.class).to(UserRepositoryImpl.class).in(Singleton.class);
    bind(UserService.class).to(UserServiceImpl.class).in(Singleton.class);
  }
}
