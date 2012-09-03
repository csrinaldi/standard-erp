package com.logikas.kratos.system.repository.impl;

import com.logikas.kratos.system.domain.UserAvatar;
import com.logikas.kratos.system.repository.UserAvatarRepository;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

public class UserAvatarRepositoryImpl implements UserAvatarRepository {

  private final Provider<EntityManager> em;

  @Inject
  UserAvatarRepositoryImpl(Provider<EntityManager> em) {
    this.em = em;
  }

  @Override
  public UserAvatar save(UserAvatar entity) {
    em.get().persist(entity);
    return entity;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Iterable<UserAvatar> findAll() {
    return em.get().createQuery("FROM UserAvatar").getResultList();
  }

  @Override
  public Long count() {
    return (long) em.get().createQuery("FROM UserAvatar").getResultList().size();
  }

  @Override
  public void delete(UserAvatar entity) {

  }

  @Override
  public boolean exists(Long primaryKey) {
    return findOne(primaryKey) != null;
  }

  @Override
  public UserAvatar findOne(Long primaryKey) {
    return em.get().find(UserAvatar.class, primaryKey);
  }
}
