package com.logikas.kratos.core.facade.jpa;

import com.logikas.kratos.core.domain.GenericEntity;
import com.logikas.kratos.core.facade.EntityAccessorFactory;
import com.logikas.kratos.core.repository.EntityAccessor;

public class JpaEntityAccessorFactory implements EntityAccessorFactory {

  @Override
  public <T, I> EntityAccessor<T, I> createAccessor(Class<T> domainType, Class<I> idType) {
    
    return (EntityAccessor<T, I>) new EntityAccessor<GenericEntity, Long>() {
      public Long getId(GenericEntity entity) {
        return entity.getId();
      }

      public Object getVersion(GenericEntity entity) {
        return entity.getVersion();
      }
    };
  }
}
