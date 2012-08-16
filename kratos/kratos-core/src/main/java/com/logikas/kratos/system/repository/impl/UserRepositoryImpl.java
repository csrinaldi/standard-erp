package com.logikas.kratos.system.repository.impl;

import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.repository.UserRepository;

import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

public class UserRepositoryImpl implements UserRepository {
  
  private final Provider<EntityManager> em;
  
  @Inject
  UserRepositoryImpl(Provider<EntityManager> em) {
    this.em = em;
  }

  @Override
  public User find(Long id) {
    return em.get().find(User.class, id);
  }
  
  @Transactional
  @Override
  public void save(User user) {
    em.get().persist(user);
  }
}
