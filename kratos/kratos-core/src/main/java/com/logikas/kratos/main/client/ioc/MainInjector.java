package com.logikas.kratos.main.client.ioc;

import com.logikas.kratos.main.client.Bootstrap;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(MainClientModule.class)
public interface MainInjector extends Ginjector {
  
  Bootstrap getBootstrap();
}
