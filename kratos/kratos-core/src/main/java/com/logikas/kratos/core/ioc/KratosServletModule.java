package com.logikas.kratos.core.ioc;

import com.logikas.kratos.core.facade.KratosRequestFactoryServlet;

import com.google.inject.servlet.ServletModule;

public class KratosServletModule extends ServletModule {
  
  @Override
  protected void configureServlets() {
    serve("requestFactory/*").with(KratosRequestFactoryServlet.class);
  }
}
