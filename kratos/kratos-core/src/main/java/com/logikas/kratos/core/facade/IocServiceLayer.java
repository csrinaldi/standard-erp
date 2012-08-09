package com.logikas.kratos.core.facade;

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
    return injector.getInstance(clazz);
  }

  @Override
  public <T extends ServiceLocator> T createServiceLocator(Class<T> clazz) {
    return injector.getInstance(clazz);
  }

/*
 TODO revisar. Esto en teoria no hace innecesario definir locator mediante anotaciones(non-Javadoc)
 
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Class<? extends Locator<?, ?>> resolveLocator(Class<?> domainType) {
    if (GenericEntityLocator.class.isAssignableFrom(domainType)) {
      final Type result = Types.newParameterizedType(GenericEntityLocator.class, domainType);
      return (Class) result;
    }
    return super.resolveLocator(domainType);
  }

  
  
  @Override
  public Class<? extends ServiceLocator> resolveServiceLocator(
      Class<? extends RequestContext> requestContext) {
    return GenericServiceLocator.class;
  }
  */
}
