package com.logikas.kratos.core.facade;

import com.logikas.kratos.core.locator.GenericEntityLocator;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.util.Types;
import com.google.web.bindery.requestfactory.server.ServiceLayerDecorator;
import com.google.web.bindery.requestfactory.shared.Locator;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

import java.lang.reflect.Type;

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
  public Class<? extends Locator<?, ?>> resolveLocator(Class<?> domainType) {
    return null; //Types.newParameterizedType(GenericEntityLocator.class, domainType);
  }

  @Override
  public <T extends ServiceLocator> T createServiceLocator(Class<T> clazz) {
    return injector.getInstance(clazz);
  }

  // TODO revisar. Esto en teoria no hace innecesario definir locator mediante anotaciones
  @Override
  public Class<? extends ServiceLocator> resolveServiceLocator(
      Class<? extends RequestContext> requestContext) {
    return GenericServiceLocator.class;
  }
}
