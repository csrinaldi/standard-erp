package com.logikas.common.auditory.guice;

import com.google.common.base.Preconditions;

import javax.inject.Provider;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public class AuditoryEntityListener {

  static Provider<EntityAuditor<?>> auditor;

  public AuditoryEntityListener() {
    Preconditions.checkState(auditor != null, "%s install is required", AuditoryModule.class
        .getSimpleName());
  }

  @PrePersist
  public void prePersist(Object entity) {
    auditor.get().prePersist(entity);
  }

  @PreUpdate
  public void preUpdate(Object entity) {
    auditor.get().preUpdate(entity);
  }
}
