package com.logikas.kratos.core.repository.jpa;

import javax.inject.Inject;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class EventBusEntityListener {

  @Inject
  private static EventBusEntityListenerImpl impl;

  @PrePersist
  public void prePersist(Object entity) {
    impl.prePersist(entity);
  }

  @PostPersist
  public void postPersist(Object entity) {
    impl.postPersist(entity);
  }

  @PreUpdate
  public void preUpdate(Object entity) {
    impl.preUpdate(entity);
  }

  @PostUpdate
  public void postUpdate(Object entity) {
    impl.postUpdate(entity);
  }

  @PostLoad
  public void postLoad(Object entity) {
    impl.postLoad(entity);
  }

  @PreRemove
  public void preRemove(Object entity) {
    impl.preRemove(entity);
  }

  @PostRemove
  public void postRemove(Object entity) {
    impl.postRemove(entity);
  }
}
