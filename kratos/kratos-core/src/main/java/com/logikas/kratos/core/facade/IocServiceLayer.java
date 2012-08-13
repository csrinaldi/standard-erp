package com.logikas.kratos.core.facade;

import com.logikas.kratos.core.domain.GenericEntity;
import com.logikas.kratos.core.locator.GenericEntityLocator;
import com.logikas.kratos.core.repository.EntityAccessor;
import com.logikas.kratos.core.repository.EntityFinder;

import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

import javax.inject.Inject;

class IocServiceLayer extends ServiceLayerDecorator {

  private final Injector injector;

  @Inject
  IocServiceLayer(Injector injector) {
    this.injector = injector;
  }

  @Override
  public <T extends Locator<?, ?>> T createLocator(Class<T> clazz) {
    final T locator = injector.getInstance(clazz);
    
    if(locator instanceof GenericEntityLocator) {
      @SuppressWarnings("rawtypes")
      final GenericEntityLocator genericLocator = (GenericEntityLocator<?, ?, ?>)locator;
      @SuppressWarnings("rawtypes")
      final EntityFinder finder = injector.getInstance(genericLocator.getFinderType()); 
      genericLocator.setFinder(finder);
      genericLocator.setAccessor(new EntityAccessor<GenericEntity, Long>() {
        @Override
        public Long getId(GenericEntity entity) {
          return entity.getId();
        }
        
        public Object getVersion(GenericEntity entity) {
          return entity.getVersion();
        }
      });      
    }
    
    return locator;    
  }

  @Override
  public <T extends ServiceLocator> T createServiceLocator(Class<T> clazz) {
    return injector.getInstance(clazz);
  }
}
