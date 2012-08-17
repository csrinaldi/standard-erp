package com.logikas.kratos.main.client.ioc;

import com.logikas.kratos.main.client.Bootstrap2;
import com.logikas.kratos.system.client.ioc.SystemClientModule;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.logikas.kratos.main.client.Bootstrap;

@GinModules({MainClientModule.class, SystemClientModule.class})
public interface MainInjector extends Ginjector {

  //Bootstrap2 getBootstrap();
  
  Bootstrap getBootstrap();
}
