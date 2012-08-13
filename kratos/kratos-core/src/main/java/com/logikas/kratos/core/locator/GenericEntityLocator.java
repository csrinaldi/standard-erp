package com.logikas.kratos.core.locator;

import com.logikas.kratos.core.repository.EntityAccessor;
import com.logikas.kratos.core.repository.EntityFinder;
import com.logikas.kratos.core.repository.Repository;

import com.google.inject.TypeLiteral;
import com.google.web.bindery.requestfactory.shared.Locator;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericEntityLocator<F extends EntityFinder<?, ?>> extends Locator<Object, Object> {

  private final Class<? extends Object> domainType;

  private final Class<? extends Object> idType;

  private final Class<F> finderType;

  private EntityFinder<?, ?> finder;

  private EntityAccessor<?, ?> accessor;

  @SuppressWarnings("unchecked")
  public GenericEntityLocator() {
    final TypeLiteral<?> actualLocatorLiteral =
        TypeLiteral.get(getClass()).getSupertype(GenericEntityLocator.class);

    final ParameterizedType actualLocatorGeneric =
        ((ParameterizedType) actualLocatorLiteral.getType());

    final Type actualFinderType = actualLocatorGeneric.getActualTypeArguments()[0];

    assert actualFinderType instanceof Class : "Wrong finder type parameter in "
        + getClass().getName();

    finderType = (Class<F>) actualFinderType;

    @SuppressWarnings({"rawtypes"})
    final TypeLiteral<Repository<?, ?>> actualFinderLiteral =
        (TypeLiteral) TypeLiteral.get(actualFinderType).getSupertype(EntityFinder.class);

    final ParameterizedType actualFinderGeneric = (ParameterizedType) actualFinderLiteral.getType();

    final Type actualDomainType = actualFinderGeneric.getActualTypeArguments()[0];

    assert actualDomainType instanceof Class : "Wrong domain type parameter in "
        + finderType.getName();

    domainType = (Class<?>) actualDomainType;

    final Type actualIdType = actualFinderGeneric.getActualTypeArguments()[1];

    assert actualIdType instanceof Class : "Wrong id type parameter in " + finderType.getName();

    idType = (Class<?>) actualIdType;
  }

  public void setFinder(EntityFinder<?, ?> finder) {
    this.finder = finder;
  }

  public void setAccessor(EntityAccessor<?, ?> accessor) {
    this.accessor = accessor;
  }

  @Override
  public Object create(Class<? extends Object> clazz) {
    try {
      return clazz.newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Object find(Class<? extends Object> clazz, Object id) {
    return ((EntityFinder) finder).find(id);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Class<Object> getDomainType() {
    return (Class) domainType;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Object getId(Object domainObject) {
    return ((EntityAccessor) accessor).getId(domainObject);
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Class<Object> getIdType() {
    return (Class) idType;
  }

  public Class<F> getFinderType() {
    return finderType;
  }

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Object getVersion(Object domainObject) {
    return ((EntityAccessor) accessor).getVersion(domainObject);
  }
}
