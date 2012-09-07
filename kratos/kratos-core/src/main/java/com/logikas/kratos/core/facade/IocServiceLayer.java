package com.logikas.kratos.core.facade;

import com.logikas.kratos.core.locator.GenericEntityLocator;
import com.logikas.kratos.core.repository.EntityAccessor;
import com.logikas.kratos.core.repository.EntityFinder;
import com.logikas.kratos.core.repository.EntityFinderLocator;

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

  private final EntityFinderLocator entityFinders;

  @Inject
  IocServiceLayer(Injector injector, ValidatorFactory validatorFactory,
      EntityAccessorFactory accessorFactory,
      EntityFinderLocator entityFinders) {
    this.injector = injector;
    this.validatorFactory = validatorFactory;
    this.accessorFactory = accessorFactory;
    this.entityFinders = entityFinders;
  }

  @SuppressWarnings({"rawtypes", "unchecked"})
  public <T extends Locator<?, ?>> T createLocator(Class<T> clazz) {

    if (GenericEntityLocator.class.isAssignableFrom(clazz)) {

      EntityFinder finder;

      GenericEntityLocator genericLocator;

      if (GenericEntityLocator.class.equals(clazz)) {

        finder = entityFinders.get(clazz);

        genericLocator = new GenericEntityLocator(finder.getClass());

      } else {

        genericLocator = (GenericEntityLocator) injector.getInstance(clazz);

        finder = (EntityFinder) injector.getInstance(genericLocator.getFinderType());
      }

      final EntityAccessor accessor =
          accessorFactory
              .createAccessor(genericLocator.getDomainType(), genericLocator.getIdType());

      genericLocator.setAccessor(accessor);

      genericLocator.setFinder(finder);

      return (T) genericLocator;
      
    } else {

      return injector.getInstance(clazz);
    }
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
