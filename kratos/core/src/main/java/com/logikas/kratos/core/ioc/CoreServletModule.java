/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.ioc;

import com.google.inject.persist.PersistFilter;
import com.google.inject.servlet.ServletModule;
import com.logikas.kratos.core.ioc.jpa.KratosPersistModule;
import com.logikas.kratos.core.server.CoreServlet;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Class CoreServletModule
 *
 *
 * Package: com.logikas.kratos.core.ioc Last modification: 22/11/2012 File:
 * CoreServletModule.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class CoreServletModule extends ServletModule {

    
    @Override
    protected void configureServlets() {

        install(new KratosPersistModule("kratos"));

        filter("/*").through(PersistFilter.class);
        
        serve("/core").with(CoreServlet.class);
        
    }
}
