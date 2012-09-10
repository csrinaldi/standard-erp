package com.logikas.kratos.core.locator;

import com.logikas.kratos.core.repository.EntityAccessor;
import com.logikas.kratos.core.repository.EntityFinder;
import com.logikas.kratos.core.repository.EntityFinders;

import com.google.inject.TypeLiteral;
import com.google.web.bindery.requestfactory.shared.Locator;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericEntityLocator<F extends EntityFinder<?, ?>> extends Locator<Object, Object> {
  
  @SuppressWarnings("unchecked")
  public static <F extends EntityFinder<?, ?>> Class<F> getFinderType(Class<? extends GenericEntityLocator<F>> locatorType) {
    
    final TypeLiteral<?> actualLocatorLiteral =
        TypeLiteral.get(locatorType).getSupertype(GenericEntityLocator.class);

    final ParameterizedType actualLocatorGeneric =
        ((ParameterizedType) actualLocatorLiteral.getType());

    final Type actualFinderType = actualLocatorGeneric.getActualTypeArguments()[0];

    assert actualFinderType instanceof Class : "Wrong finder type parameter in "
        + locatorType.getName();
    
    return (Class<F>) actualFinderType;        
  }

  private Class<? extends Object> domainType;

  private Class<? extends Object> idType;

  private EntityFinder<?, ?> finder;

  private EntityAccessor<?, ?> accessor;
  
  @SuppressWarnings({"rawtypes", "unchecked"})
  public GenericEntityLocator() {
    
    final Class<F> finderType = getFinderType((Class)getClass()); 
    
    domainType = EntityFinders.getDomainType((Class)finderType);

    idType = EntityFinders.getIdType((Class)finderType);   
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
    return ((EntityFinder) finder).find((Serializable) id);
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

  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Object getVersion(Object domainObject) {
    return ((EntityAccessor) accessor).getVersion(domainObject);
  }
}
