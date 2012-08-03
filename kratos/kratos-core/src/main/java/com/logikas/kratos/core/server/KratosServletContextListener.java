package com.logikas.kratos.core.server;

import com.logikas.kratos.core.ioc.KratosServletModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class KratosServletContextListener extends GuiceServletContextListener {

  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new KratosServletModule());
  }
}
