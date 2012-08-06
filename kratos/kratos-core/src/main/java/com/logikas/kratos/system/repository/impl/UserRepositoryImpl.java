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
}
