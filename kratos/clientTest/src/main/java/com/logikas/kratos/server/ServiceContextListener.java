/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.server;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.logikas.kratos.client.ioc.GuiceFactory;
import com.logikas.kratos.client.ioc.ServletModule;

/**
 *
 * @author cristian
 */
public class ServiceContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {

        GuiceFactory.getInjector().injectMembers(new ServletModule());

        return GuiceFactory.getInjector();
    }
}
