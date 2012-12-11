/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.server;

import com.logikas.kratos.core.osgi.CoreActivator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Class StartupListener
 *
 *
 * Package: com.logikas.kratos.core.server Last modification: 03/12/2012 File:
 * StartupListener.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public final class StartupListener
        implements ServletContextListener {

    CoreActivator core;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            ServletContext sc = event.getServletContext();
            BundleContext context = (BundleContext) sc.getAttribute("osgi-bundlecontext");
            System.out.println("Initialize Bundle Context");

            context.registerService("sc", sc, null);


            core = new CoreActivator();
            core.start(context);

        } catch (Exception ex) {
            Logger.getLogger(StartupListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        BundleContext context = (BundleContext) event.getServletContext().getAttribute("osgi-bundlecontext");
        ServiceReference sref = context.getServiceReference("sc");
        context.ungetService(sref);

    }
}
