package com.logikas.kratos.core.locator;

import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

import javax.inject.Inject;

public class GenericServiceLocator implements ServiceLocator {

  private final Injector injector;

  @Inject
  GenericServiceLocator(Injector injector) {
    this.injector = injector;
  }

  @Override
  public Object getInstance(Class<?> clazz) {
    return injector.getInstance(clazz);
  }
}
