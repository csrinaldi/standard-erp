package com.logikas.security.audit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;

import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.google.inject.Provider;
import com.logikas.common.domain.Auditable;
import com.logikas.common.domain.Created;
import com.logikas.common.domain.CreatedBy;
import com.logikas.common.domain.LastModified;
import com.logikas.common.domain.LastModifiedBy;
import com.logikas.core.security.persistence.User;

public class AuditEntityListener {

  private static class AnnotatedAuditableInvoker {

    private final Method setCreated;
    private final Method setCreatedBy;
    private final Method setLastModified;
    private final Method setLastModifiedBy;

    public AnnotatedAuditableInvoker(Method setCreated, Method setCreatedBy,
        Method setLastModified, Method setLastModifiedBy) {
      this.setCreated = setCreated;
      this.setCreatedBy = setCreatedBy;
      this.setLastModified = setLastModified;
      this.setLastModifiedBy = setLastModifiedBy;
    }

    private void invoke(Object self, Method method, Object argument) {
      if (method != null) {
        try {
          setCreatedBy.invoke(self, argument);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }

    public void setCreated(Object self, Date created) {
      invoke(self, setCreated, created);
    }

    public void setCreatedBy(Object self, User createdBy) {
      invoke(self, setCreatedBy, createdBy);
    }

    public void setLastModified(Object self, Date lastModified) {
      invoke(self, setLastModified, lastModified);
    }

    public void setLastModifiedBy(Object self, User lastModifiedBy) {
      invoke(self, setLastModifiedBy, lastModifiedBy);
    }
  }

  private static class AnnotatedAuditable implements Auditable {

    private final Object self;
    private final AnnotatedAuditableInvoker invoker;

    public AnnotatedAuditable(Object self, AnnotatedAuditableInvoker invoker) {
      this.self = self;
      this.invoker = invoker;
    }

    @Override
    public User getCreatedBy() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setCreatedBy(User createdBy) {
      invoker.setCreatedBy(createdBy, createdBy);
    }

    @Override
    public Date getCreated() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setCreated(Date created) {
      invoker.setCreated(self, created);
    }

    @Override
    public User getLastModifiedBy() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setLastModifiedBy(User lastModifiedBy) {
      invoker.setLastModifiedBy(self, lastModifiedBy);
    }

    @Override
    public Date getLastModified() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setLastModified(Date lastModified) {
      invoker.setLastModified(self, lastModified);
    }
  }

  private final HashMap<Class<?>, AnnotatedAuditableInvoker> annotated;

  public AuditEntityListener() {
    annotated = new HashMap<Class<?>, AnnotatedAuditableInvoker>();
  }

  private Method conforms(Method previous, Method method,
      Class<? extends Annotation> annotationClass, Class<?> argumentClass) {

    if (previous != null) {
      throw new RuntimeException("setter for @" + annotationClass.getClass().getSimpleName()
          + " defined twice in class " + previous.getDeclaringClass().getName());
    }

    if (method.getParameterTypes().length != 1) {
      throw new RuntimeException("wrong argument number for method " + method.getName()
          + " in class " + method.getDeclaringClass().getName());
    }

    if (!method.getParameterTypes()[0].isAssignableFrom(argumentClass)) {
      throw new RuntimeException("wrong argument type for method " + method.getName()
          + " in class " + method.getDeclaringClass().getName());
    }

    return method.isAnnotationPresent(annotationClass) ? method : null;
  }

  private synchronized AnnotatedAuditableInvoker getInvoker(Class<?> entityClass) {

    final AnnotatedAuditableInvoker registered = annotated.get(entityClass);

    if (registered != null) {
      return registered;
    }

    Method setCreated = null;
    Method setCreatedBy = null;
    Method setLastModified = null;
    Method setLastModifiedBy = null;

    for (final Method m : entityClass.getMethods()) {
      setCreated = conforms(setCreated, m, Created.class, Date.class);
      setCreatedBy = conforms(setCreatedBy, m, CreatedBy.class, User.class);
      setLastModified = conforms(setLastModified, m, LastModified.class, Date.class);
      setLastModifiedBy = conforms(setLastModifiedBy, m, LastModifiedBy.class, User.class);
    }

    final AnnotatedAuditableInvoker invoker =
        new AnnotatedAuditableInvoker(setCreated, setCreatedBy, setLastModified, setLastModifiedBy);

    annotated.put(entityClass, invoker);

    return invoker;
  }

  @Inject
  private static Provider<Date> now;

  @Inject
  private static Provider<User> user;

  private Auditable asAuditable(Object entity) {
    
    if (entity instanceof Auditable) {
      return (Auditable) entity;
    }

    final AnnotatedAuditableInvoker invoker = getInvoker(entity.getClass());

    return new AnnotatedAuditable(entity, invoker);
  }

  @PrePersist
  public void prePersist(Object entity) {
    
    final Auditable auditable = asAuditable(entity);
    
    auditable.setCreated(now.get());
    auditable.setCreatedBy(user.get());
  }

  @PreUpdate
  public void preUpdate(Object entity) {

    final Auditable auditable = asAuditable(entity);

    auditable.setLastModified(now.get());
    auditable.setLastModifiedBy(user.get());
  }
}
