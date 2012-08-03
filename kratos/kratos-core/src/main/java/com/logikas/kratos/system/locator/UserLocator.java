package com.logikas.kratos.system.locator;

import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.repository.UserRepository;

import com.google.web.bindery.requestfactory.shared.Locator;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserLocator extends Locator<User, Long> {
  
  private final UserRepository repository;
  
  @Inject
  UserLocator(UserRepository repository) {
    this.repository = repository;
  }

  @Override
  public User create(Class<? extends User> clazz) {
    return new User();
  }

  @Override
  public User find(Class<? extends User> clazz, Long id) {
    return repository.find(id);
  }

  @Override
  public Class<User> getDomainType() {
    return User.class;
  }

  @Override
  public Long getId(User domainObject) {
    return domainObject.getId();
  }

  @Override
  public Class<Long> getIdType() {
    return Long.class;
  }

  @Override
  public Object getVersion(User domainObject) {
    return domainObject.getVersion();
  }
}
