package com.logikas.kratos.system.service.impl;

import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.repository.UserRepository;
import com.logikas.kratos.system.service.UserService;

import java.util.List;

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
    repository.save(user);
  }

  @Override
  public boolean isAdmin(User user) {
    return true;
  }

  @Override
  public List<User> findByName(String name, int start, int rows) {
    return repository.findByName(name, start, rows);
  }

  @Override
  public List<User> findAll(int start, int rows) {
    return repository.findAll(start, rows);
  }
}
