package com.logikas.kratos.core.facade;

import com.logikas.kratos.core.locator.GenericEntityLocator;
import com.logikas.kratos.core.repository.EntityAccessor;
import com.logikas.kratos.core.repository.EntityFinder;

import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;

class IocServiceLayer extends ServiceLayerDecorator {

  private final Injector injector;

  private final ValidatorFactory validatorFactory;
  
  private final EntityAccessorFactory accessorFactory;
  
  @Inject
  IocServiceLayer(Injector injector, ValidatorFactory validatorFactory, EntityAccessorFactory accessorFactory) {
    this.injector = injector;
    this.validatorFactory = validatorFactory;
    this.accessorFactory = accessorFactory;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T extends Locator<?, ?>> T createLocator(Class<T> clazz) {
    final T locator = injector.getInstance(clazz);

    if (locator instanceof GenericEntityLocator) {
      @SuppressWarnings("rawtypes")
      final GenericEntityLocator genericLocator = (GenericEntityLocator) locator;

      @SuppressWarnings("rawtypes")
      final EntityFinder finder = (EntityFinder)injector.getInstance(genericLocator.getFinderType());
      genericLocator.setFinder(finder);

      @SuppressWarnings("rawtypes")
      final EntityAccessor accessor =
          accessorFactory
              .createAccessor(genericLocator.getDomainType(), genericLocator.getIdType());
      
      genericLocator.setAccessor(accessor);
    }

    return locator;
  }

  @Override
  public <T extends ServiceLocator> T createServiceLocator(Class<T> clazz) {
    return injector.getInstance(clazz);
  }
  
  @Override
  public <T> Set<ConstraintViolation<T>> validate(T domainObject) {    
    return validatorFactory.getValidator().validate(domainObject);
  }
}
