package com.logikas.kratos.core.ioc;

import com.logikas.kratos.core.facade.KratosRequestFactoryServlet;

import com.google.inject.Singleton;
import com.google.inject.servlet.ServletModule;
import com.google.web.bindery.requestfactory.server.DefaultExceptionHandler;
import com.google.web.bindery.requestfactory.server.ExceptionHandler;

public class KratosServletModule extends ServletModule {
  
  @Override
  protected void configureServlets() {
    bind(ExceptionHandler.class).to(DefaultExceptionHandler.class).in(Singleton.class);
    serve("/gwtRequest").with(KratosRequestFactoryServlet.class);
  }
}
