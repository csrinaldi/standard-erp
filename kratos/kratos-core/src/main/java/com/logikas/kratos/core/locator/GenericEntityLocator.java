package com.logikas.kratos.core.locator;

import com.logikas.kratos.core.domain.GenericEntity;

import com.google.web.bindery.requestfactory.shared.Locator;

public class GenericEntityLocator<T extends GenericEntity> extends Locator<T, Long>{

  @Override
  public T create(Class<? extends T> clazz) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T find(Class<? extends T> clazz, Long id) {
    return null;
  }

  @Override
  public Class<T> getDomainType() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Long getId(T domainObject) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Class<Long> getIdType() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object getVersion(T domainObject) {
    // TODO Auto-generated method stub
    return null;
  }

}
