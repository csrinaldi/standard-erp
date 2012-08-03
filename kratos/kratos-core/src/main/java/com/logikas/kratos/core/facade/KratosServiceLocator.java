package com.logikas.kratos.core.facade;

import com.google.inject.Injector;
import com.google.web.bindery.requestfactory.shared.ServiceLocator;

import javax.inject.Inject;

public class KratosServiceLocator implements ServiceLocator {

  private final Injector injector;

  @Inject
  KratosServiceLocator(Injector injector) {
    this.injector = injector;
  }

  @Override
  public Object getInstance(Class<?> clazz) {
    return injector.getInstance(clazz);
  }
}