package com.logikas.kratos.system.ioc;

import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.service.UserService;

import javax.inject.Inject;
import javax.inject.Provider;

public class CurrentUserProvider implements Provider<User> {

  private final UserService service;

  @Inject
  CurrentUserProvider(UserService service) {
    this.service = service;
  }

  @Override
  public User get() {
    return service.find(0L);
  }
}
