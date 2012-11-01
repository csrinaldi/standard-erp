/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.ioc;

import com.logikas.kratos.client.TestServlet;

/**
 *
 * @author cristian
 */
public class ServletModule extends com.google.inject.servlet.ServletModule {

    @Override
    protected void configureServlets() {

        serve("/test").with(TestServlet.class);

        install(new ImportModule());
    }
}
