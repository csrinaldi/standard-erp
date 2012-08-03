package com.logikas.kratos.main.client;

import com.logikas.kratos.main.client.ioc.MainInjector;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;

public class KratosMain implements EntryPoint {
  
	public void onModuleLoad() {
	  final MainInjector injector = GWT.create(MainInjector.class);
	  final Bootstrap bootstrap = injector.getBootstrap();
	  bootstrap.init();
	}
}
