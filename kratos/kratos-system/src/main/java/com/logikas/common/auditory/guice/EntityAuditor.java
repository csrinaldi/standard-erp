package com.logikas.common.auditory.guice;


import com.google.inject.TypeLiteral;
import com.logikas.common.auditory.Auditory;
import com.logikas.common.auditory.domain.Auditable;
import com.logikas.common.auditory.domain.CreatedBy;
import com.logikas.common.auditory.domain.CreatedDate;
import com.logikas.common.auditory.domain.UpdatedBy;
import com.logikas.common.auditory.domain.UpdatedDate;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import javax.persistence.Entity;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
@Singleton
class EntityAuditor<S> {

  private static class AnnotatedAuditableInvoker<E, S> {

    private final AttributeAccessor<E, Date> createdDate;
    private final AttributeAccessor<E, S> createdBy;
    private final AttributeAccessor<E, Date> updatedDate;
    private final AttributeAccessor<E, S> updatedBy;

    public AnnotatedAuditableInvoker(AttributeAccessor<E, Date> createdDate,
        AttributeAccessor<E, S> createdBy, AttributeAccessor<E, Date> updatedDate,
        AttributeAccessor<E, S> updatedBy) {
      this.createdDate = createdDate;
      this.createdBy = createdBy;
      this.updatedDate = updatedDate;
      this.updatedBy = updatedBy;
    }

    private <T> void invoke(AttributeAccessor<E, T> setter, E self, T argument) {
      try {
        setter.setValue(self, argument);
      } catch (RuntimeException e) {
        throw e;
      } catch (Throwable t) {
        throw new RuntimeException(t);
      }
    }

    public void setCreated(E self, Date date) {
      invoke(createdDate, self, date);
    }

    public void setCreatedBy(E self, S subject) {
      invoke(createdBy, self, subject);
    }

    public void setLastUpdatedDate(E self, Date date) {
      invoke(updatedDate, self, date);
    }

    public void setLastUpdatedBy(E self, S subject) {
      invoke(updatedBy, self, subject);
    }
  }

  private static class AnnotatedAuditable<E, S> implements Auditable<S, Serializable> {

    private static final long serialVersionUID = 1L;
    
    private final E self;
    private final AnnotatedAuditableInvoker<E, S> invoker;

    public AnnotatedAuditable(E self, AnnotatedAuditableInvoker<E, S> invoker) {
      this.self = self;
      this.invoker = invoker;
    }

    @Override
    public S getCreatedBy() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setCreatedBy(S createdBy) {
      invoker.setCreatedBy(self, createdBy);
    }

    @Override
    public Date getCreatedDate() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setCreatedDate(Date creationDate) {
      invoker.setCreated(self, creationDate);
    }

    @Override
    public S getUpdatedBy() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setUpdatedBy(S lastUpdatedBy) {
      invoker.setLastUpdatedBy(self, lastUpdatedBy);
    }

    @Override
    public Date getUpdatedDate() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setUpdatedDate(Date lastUpdatedDate) {
      invoker.setLastUpdatedDate(self, lastUpdatedDate);
    }

    @Override
    public Serializable getId() {
      throw new UnsupportedOperationException();
    }

    @Override
    public boolean isNew() {
      throw new UnsupportedOperationException();
    }    
  }

  private final TypeLiteral<S> subjectType;

  private final Provider<S> subject;

  private final Provider<Date> now;

  private final Map<Class<?>, AuditoryFieldConverter<Date, ?>> timeConverters;

  private final Map<Class<?>, AuditoryFieldConverter<S, ?>> userConverters;

  @Inject
  EntityAuditor(TypeLiteral<S> subjectType, @Auditory Provider<S> subject,
      @Auditory Provider<Date> now,
      @Auditory Map<Class<?>, AuditoryFieldConverter<Date, ?>> timeConverters,
      @Auditory Map<Class<?>, AuditoryFieldConverter<S, ?>> userConverters) {
    this.subjectType = subjectType;
    this.subject = subject;
    this.now = now;
    this.timeConverters = timeConverters;
    this.userConverters = userConverters;
    this.whiteList = new HashSet<Class<?>>();
    this.invokers = new ConcurrentHashMap<Class<?>, AnnotatedAuditableInvoker<?, S>>();
  }

  private <E, T> AttributeAccessor<E, T> tryCreate(Member member) {
    return member instanceof Method ? PropertyAttributeAccessor.<E, T> tryCreate((Method) member)
        : FieldAttributeAccessor.<E, T> tryCreate((Field) member);
  }

  @SuppressWarnings("unchecked")
  private <E, T> AttributeAccessor<E, T> conforms(AttributeAccessor<E, T> previous, Member member,
      Class<? extends Annotation> annotationClass, Class<T> type,
      Map<Class<?>, AuditoryFieldConverter<T, ?>> converters) {

    if (!((AnnotatedElement) member).isAnnotationPresent(annotationClass)) {
      return previous;
    }

    if (!isNull(previous)) {
      throw new RuntimeException("Attribute annotated with @" + annotationClass.getSimpleName()
          + " defined twice in class " + previous.getMember().getDeclaringClass().getName());
    }

    final AttributeAccessor<E, Object> current = tryCreate(member);

    if (current == null) {
      throw new RuntimeException("Annotated member '" + member.getName() + "' of class '"
          + member.getDeclaringClass().getName() + "' is not a valid attribute");
    }

    if (current.getValueType().isAssignableFrom(type)) {
      return (AttributeAccessor<E, T>) current;
    }

    final AuditoryFieldConverter<T, Object> c =
        (AuditoryFieldConverter<T, Object>) converters.get(current.getValueType());

    if (c != null) {
      return new ConvertibleAttributeAccessor<E, T, Object>(current, c, type);
    }

    throw new RuntimeException("Not supported argument type for attribute " + member.getName()
        + " of class " + member.getDeclaringClass().getName());
  }

  private static final AttributeAccessor<Object, Object> NULL_ACCESSOR =
      new AttributeAccessor<Object, Object>() {

        @Override
        public String getName() {
          throw new UnsupportedOperationException();
        }

        @Override
        public Object getValue(Object entity) throws Throwable {
          return null;
        }

        @Override
        public void setValue(Object entity, Object value) throws Throwable {

        }

        @Override
        public Member getMember() {
          throw new UnsupportedOperationException();
        }

        @Override
        public Class<? extends Object> getValueType() {
          return void.class;
        }
      };

  @SuppressWarnings({"unchecked"})
  private static <E, T> AttributeAccessor<E, T> nullAccessor() {
    return (AttributeAccessor<E, T>) NULL_ACCESSOR;
  }

  private static <E, T> boolean isNull(AttributeAccessor<E, T> accessor) {
    return nullAccessor().equals(accessor);
  }

  private final Set<Class<?>> whiteList;

  private final Map<Class<?>, AnnotatedAuditableInvoker<?, S>> invokers;

  private <E> AnnotatedAuditableInvoker<E, S> getInvoker(Class<E> entityType) {

    if (whiteList.contains(entityType)) {
      return null;
    }

    @SuppressWarnings("unchecked")
    final AnnotatedAuditableInvoker<E, S> invoker =
        (AnnotatedAuditableInvoker<E, S>) invokers.get(entityType);

    if (invoker != null) {
      return invoker;
    }

    AttributeAccessor<E, Date> setCD = nullAccessor();
    AttributeAccessor<E, S> setCB = nullAccessor();
    AttributeAccessor<E, Date> setLUD = nullAccessor();
    AttributeAccessor<E, S> setLUB = nullAccessor();

    @SuppressWarnings("unchecked")
    final Class<S> userClass = (Class<S>) subjectType.getType();

    final ArrayList<Member> members = new ArrayList<Member>();

    Collections.addAll(members, entityType.getMethods());
    Collections.addAll(members, entityType.getFields());

    for (final Member m : members) {
      setCD = conforms(setCD, m, CreatedDate.class, Date.class, timeConverters);
      setCB = conforms(setCB, m, CreatedBy.class, userClass, userConverters);
      setLUD = conforms(setLUD, m, UpdatedDate.class, Date.class, timeConverters);
      setLUB = conforms(setLUB, m, UpdatedBy.class, userClass, userConverters);
    }

    if (!isNull(setCD) || !isNull(setCB) || !isNull(setLUD) || !isNull(setLUB)) {

      final AnnotatedAuditableInvoker<E, S> result =
          new AnnotatedAuditableInvoker<E, S>(setCD, setCB, setLUD, setLUB);

      invokers.put(entityType, result);

      return result;
    }

    whiteList.add(entityType);

    return null;
  }

  @SuppressWarnings("unchecked")
  private <U, T extends U> Class<U> getEntityType(Class<T> clazz) {
    for (Class<?> c = clazz; c != null; c = c.getSuperclass()) {
      if (c.isAnnotationPresent(Entity.class)) {
        return (Class<U>) c;
      }
    }
    throw new IllegalArgumentException("Class '" + clazz.getName()
        + "' is not a valid Entity class");
  }

  @SuppressWarnings("unchecked")
  private <E> Auditable<S, Serializable> asAuditable(E entity) {

    if (entity instanceof Auditable) {
      return (Auditable<S, Serializable>) entity;
    }
    
    final AnnotatedAuditableInvoker<E, S> invoker =
        getInvoker((Class<E>) getEntityType((Class<E>) entity.getClass()));

    return invoker == null ? null : new AnnotatedAuditable<E, S>(entity, invoker);
  }

  public void prePersist(Object entity) {

    final Auditable<S, Serializable> auditable = asAuditable(entity);

    if (auditable != null) {
      auditable.setCreatedDate(now.get());
      auditable.setCreatedBy(subject.get());
    }
  }

  public void preUpdate(Object entity) {

    final Auditable<S, Serializable> auditable = asAuditable(entity);

    if (auditable != null) {
      auditable.setUpdatedDate(now.get());
      auditable.setUpdatedBy(subject.get());
    }
  }
}
