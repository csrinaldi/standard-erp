package com.logikas.kratos.system.service.impl;

import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.repository.UserRepository;
import com.logikas.kratos.system.service.UserService;

import javax.inject.Inject;

public class UserServiceImpl implements UserService {

  private final UserRepository repository;
  
  @Inject
  UserServiceImpl(UserRepository repository) {
    this.repository = repository;
  }
  
  @Override
  public User find(Long id) {
    return repository.find(id);
  }
  
  public void save(User user) {
    
  }
}
