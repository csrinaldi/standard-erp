package com.logikas.kratos.core.locator;

import com.logikas.kratos.core.domain.GenericEntity;
import com.logikas.kratos.core.repository.Repository;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.util.Types;
import com.google.web.bindery.requestfactory.shared.Locator;

import java.lang.reflect.Type;

import javax.inject.Inject;

public class GenericEntityLocator extends Locator<GenericEntity, Long> {

  private final Injector injector;

  @Inject
  GenericEntityLocator(Injector injector) {
    this.injector = injector;
  }

  @Override
  public GenericEntity create(Class<? extends GenericEntity> clazz) {
    try {
      return clazz.newInstance();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public GenericEntity find(Class<? extends GenericEntity> clazz, Long id) {
    final Type type = Types.newParameterizedType(Repository.class, clazz, Long.class);
    @SuppressWarnings({"rawtypes", "unchecked"})
    final Repository<GenericEntity, Long> repository =
        (Repository) injector.getInstance(Key.get(type));
    return repository.find(id);
  }

  @Override
  public Class<GenericEntity> getDomainType() {
    return null;
  }

  @Override
  public Long getId(GenericEntity domainObject) {
    return domainObject.getId();
  }

  @Override
  public Class<Long> getIdType() {
    return Long.class;
  }

  @Override
  public Object getVersion(GenericEntity domainObject) {
    return domainObject.getVersion();
  }
}
