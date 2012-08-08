package com.logikas.kratos.core.facade;

import com.google.web.bindery.requestfactory.server.ExceptionHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class KratosRequestFactoryServlet extends RequestFactoryServlet {

  @Inject
  KratosRequestFactoryServlet(ExceptionHandler exceptionHandler, IocServiceLayer iocServiceLayer) {
    super(exceptionHandler, iocServiceLayer);
  }
}
