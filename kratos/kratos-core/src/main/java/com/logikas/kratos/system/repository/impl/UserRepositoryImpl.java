package com.logikas.kratos.system.repository.impl;

import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

  @Override
  public User find(Long id) {
    final User user = new User();
    user.setId(id);
    return user;
  }

  @Override
  public Long getId(User entity) {
    return entity.getId();
  }

  @Override
  public Object getVersion(User entity) {
    return entity.getVersion();
  }

  @Override
  public Class<User> getDomainType() {
    return User.class;
  }

  @Override
  public Class<Long> getIdType() {
    return Long.class;
  }

  @Override
  public User create() {
    return new User();
  }
}
