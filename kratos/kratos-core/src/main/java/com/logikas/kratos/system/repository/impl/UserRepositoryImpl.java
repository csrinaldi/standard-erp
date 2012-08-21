package com.logikas.kratos.system.repository.impl;

import com.logikas.kratos.system.domain.User;
import com.logikas.kratos.system.repository.UserRepository;

import com.google.inject.persist.Transactional;

import java.util.List;

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
  public User findOne(Long id) {
    return em.get().find(User.class, id);
  }

  @Transactional
  @Override
  public User save(User user) {
    em.get().persist(user);
    return user;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Iterable<User> findAll() {
    return em.get().createNamedQuery("FROM User").getResultList();
  }

  @Override
  public Long count() {
    return (Long) em.get().createQuery("SELECT COUNT(*) FROM User").getSingleResult();
  }

  @Transactional
  @Override
  public void delete(User entity) {
    em.get().remove(entity);
  }

  @Override
  public boolean exists(Long primaryKey) {
    return findOne(primaryKey) != null;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<User> findByName(String name, int start, int rows) {
    return em.get().createQuery("FROM User u WHERE u.name = :name").setParameter("name", name)
        .setFirstResult(start).setMaxResults(rows).getResultList();
  }
}
