package com.logikas.common.repository.jpa;

import com.google.common.base.Preconditions;

import java.util.Date;

import javax.inject.Provider;
import javax.persistence.EntityManager;

public class JpaRepositories {
  
  public static void initialize(JpaRepository<?, ?> repository, Provider<EntityManager> em,
      Provider<Transactor> transactor, Provider<Date> now) {
    Preconditions.checkState(repository.em == null, "EntityManager already initialized");
    Preconditions.checkState(repository.transactor == null, "Transactor already initialized");
    Preconditions.checkState(repository.now == null, "Date provider already initialized");
    repository.em = em;
    repository.transactor = transactor;
    repository.now = now;
  }
}
