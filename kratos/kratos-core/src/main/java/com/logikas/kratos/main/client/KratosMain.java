package com.logikas.kratos.main.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.logikas.kratos.main.client.ioc.MainInjector;

public class KratosMain implements EntryPoint {

    @Override
    public void onModuleLoad() {
        final MainInjector injector = GWT.create(MainInjector.class);
        //final Bootstrap2 bootstrap = injector.getBootstrap();
        //bootstrap.init();

        final Bootstrap bootstrap = injector.getBootstrap();
        bootstrap.start();
    }
}
