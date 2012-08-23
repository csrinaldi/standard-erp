package com.logikas.kratos.core.facade.jpa;

import com.logikas.kratos.core.facade.EntityAccessorFactory;
import com.logikas.kratos.core.repository.EntityAccessor;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

import javax.inject.Inject;
import javax.persistence.metamodel.Metamodel;

public class JpaEntityAccessorFactory implements EntityAccessorFactory {

  private Metamodel metamodel;

  @Inject
  JpaEntityAccessorFactory(Metamodel metamodel) {
    this.metamodel = metamodel;
  }

  static interface MemberGetter<T> {
    T getValue(Object owner);
  }

  static abstract class AbstractMemberGetter<T, M extends Member> implements MemberGetter<T> {

    protected final M member;

    AbstractMemberGetter(M member) {
      this.member = member;
    }
  }

  static class MethodMemberGetter<T> extends AbstractMemberGetter<T, Method> {

    MethodMemberGetter(Method m) {
      super(m);
    }

    @SuppressWarnings("unchecked")
    public T getValue(Object owner) {
      try {
        return (T) member.invoke(owner);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

  static class FieldMemberGetter<T> extends AbstractMemberGetter<T, Field> {

    FieldMemberGetter(Field m) {
      super(m);
    }

    @SuppressWarnings("unchecked")
    public T getValue(Object owner) {
      try {
        return (T) member.get(owner);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

  static <T> MemberGetter<T> createGetter(Member m) {
    if (m instanceof Method) {
      return new MethodMemberGetter<T>((Method) m);
    }
    if (m instanceof Field) {
      return new FieldMemberGetter<T>((Field) m);
    }
    throw new RuntimeException("Unknown member " + m.getName());
  }

  @Override
  public <T, I> EntityAccessor<T, I> createAccessor(Class<T> domainType, Class<I> idType) {

    final MemberGetter<I> idGetter =
        createGetter(metamodel.entity(domainType).getId(idType).getJavaMember());

    final MemberGetter<Object> versionGetter =
        createGetter(metamodel.entity(domainType).getVersion(long.class).getJavaMember());

    return (EntityAccessor<T, I>) new EntityAccessor<T, I>() {
      public I getId(T entity) {
        return idGetter.getValue(entity);
      }

      public Object getVersion(T entity) {
        return versionGetter.getValue(entity);
      }
    };
  }
}
