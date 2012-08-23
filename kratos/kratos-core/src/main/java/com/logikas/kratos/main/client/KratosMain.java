package com.logikas.kratos.main.client;

import com.logikas.kratos.main.client.ioc.MainInjector2;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.logikas.kratos.main.client.ioc.MainInjector;

public class KratosMain implements EntryPoint {

  public void onModuleLoad() {
    final MainInjector2 injector = GWT.create(MainInjector2.class);
    final Bootstrap2 bootstrap = injector.getBootstrap();
    bootstrap.init();
    
    //final Bootstrap bootstrap = injector.getBootstrap();
    //bootstrap.start();
  }
}
