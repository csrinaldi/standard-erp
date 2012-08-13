package com.logikas.kratos.core.locator;

import com.logikas.kratos.core.repository.EntityAccessor;
import com.logikas.kratos.core.repository.EntityFinder;
import com.logikas.kratos.core.repository.Repository;

import com.google.inject.TypeLiteral;
import com.google.web.bindery.requestfactory.shared.Locator;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericEntityLocator<T, I, F extends EntityFinder<T, I>> extends Locator<T, I> {

  private EntityFinder<T, I> finder;

  private final Class<T> domainType;

  private final Class<I> idType;
  
  private final Class<F> finderType;

  private EntityAccessor<T, I> accessor;
  
  @SuppressWarnings("unchecked")
  public GenericEntityLocator() {
    final TypeLiteral<?> literal =
        TypeLiteral.get(getClass()).getSupertype(GenericEntityLocator.class);

    final ParameterizedType generic = ((ParameterizedType) literal.getType());

    @SuppressWarnings({"unused", "rawtypes"})
    final TypeLiteral<Repository<T, I>> appliedGeneric = (TypeLiteral) TypeLiteral.get(generic);

    final Type actualDomainType = generic.getActualTypeArguments()[0];

    assert actualDomainType instanceof Class:"Wrong domain type parameter in " + getClass().getName();

    domainType = (Class<T>) actualDomainType;

    final Type actualIdType = generic.getActualTypeArguments()[1];

    assert actualIdType instanceof Class: "Wrong id type parameter in " + getClass().getName();

    idType = (Class<I>) actualIdType;
    
    final Type actualFinderType = generic.getActualTypeArguments()[2];

    assert actualIdType instanceof Class: "Wrong finder type parameter in " + getClass().getName();

    finderType = (Class<F>) actualFinderType;    
  }

  public void setFinder(EntityFinder<T, I> finder) {   
    this.finder = finder;
  }
  
  public void setAccessor(EntityAccessor<T, I> accessor) {
    this.accessor = accessor;
  }

  @Override
  public T create(Class<? extends T> clazz) {
    try {
      return clazz.newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public T find(Class<? extends T> clazz, I id) {
    return finder.find(id);
  }

  @Override
  public Class<T> getDomainType() {
    return domainType;
  }

  @Override
  public I getId(T domainObject) {
    return accessor.getId(domainObject);
  }

  @Override
  public Class<I> getIdType() {
    return idType;
  }
  
  public Class<F> getFinderType() {
    return finderType;
  }

  @Override
  public Object getVersion(T domainObject) {
    return accessor.getVersion(domainObject);
  }
}
