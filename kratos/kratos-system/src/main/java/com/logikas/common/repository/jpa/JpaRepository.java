package com.logikas.common.repository.jpa;


import com.google.common.base.Preconditions;
import com.logikas.common.persistence.domain.SoftDeletable;
import com.logikas.common.repository.Repositories;
import com.logikas.common.repository.Repository;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.path.EntityPathBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.inject.Provider;
import javax.persistence.EntityManager;

public class JpaRepository<T, ID extends Serializable> implements Repository<T, ID> {

  private final Class<T> entityType;

  Provider<EntityManager> em = null;

  Provider<Transactor> transactor = null;

  Provider<Date> now = null;

  private EntityPathBase<T> self = null;

  @SuppressWarnings("unchecked")
  protected JpaRepository() {
    entityType = Repositories.entityType((Class<? extends Repository<T, ID>>) getClass());
  }

  protected Class<T> entityType() {
    return entityType;
  }

  protected EntityPathBase<T> self() {
    if (self == null) {
      self = new EntityPathBase<T>(entityType(), entityType().getSimpleName());
    }
    return self;
  }

  @Override
  public T find(ID id) {
    return em().find(entityType(), id);
  }

  @Override
  public Iterable<T> findAll(int offset, int limit) {
    return from(self()).offset(offset).limit(limit).list(self());
  }

  @Override
  public Iterable<T> findAll(Iterable<ID> ids) {
    final ArrayList<T> all = new ArrayList<T>();
    for (final ID id : ids) {
      all.add(find(id));
    }
    return all;
  }

  @Override
  public <S extends T> S save(final S entity) {
    return transactor().perform(new Transactor.Execution<S>() {
      @Override
      public S execute() {
        em().persist(entity);
        return entity;
      }
    });
  }

  @Override
  public void delete(final T entity) {
    transactor().perform(new Transactor.Execution<T>() {
      @Override
      public T execute() {
        em().remove(entity);
        return null;
      }
    });
  }
  
  @Override
  public void softDelete(T entity) {
    if(entity instanceof SoftDeletable) {
      @SuppressWarnings("unchecked")
      final SoftDeletable<ID> sd = (SoftDeletable<ID>) entity;
      sd.setDeletedDate(now());
    } else {
      delete(entity);      
    }
  }

  private Transactor transactor() {
    Preconditions.checkNotNull(transactor, "Transactor is not initialized");
    return transactor.get();
  }

  protected EntityManager em() {
    Preconditions.checkNotNull(em, "EntityManager is not initialized");
    return em.get();
  }

  protected Date now() {
    Preconditions.checkNotNull(now, "Date provider is not initialized");
    return now.get();
  }

  protected JPAQuery from(EntityPath<?>... o) {
    return query().from(o);
  }

  protected JPAQuery query() {
    return new JPAQuery(em());
  }

  @Override
  public long count() {
    return from(self()).count();
  }
}
