/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.server;

import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleListener;
import org.osgi.framework.FrameworkEvent;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

/**
 *
 * @author cristian
 */
public class ServiceContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Enumeration<String> e = sce.getServletContext().getAttributeNames();
        System.out.println("\ncontextInitialized");
        while (e.hasMoreElements()) {
            String string = e.nextElement();
            System.out.println(string);
        }

        BundleContext cb = (BundleContext) sce.getServletContext().getAttribute("contextInitialized");
        if (cb != null) {

            cb.addBundleListener(new BundleListener() {
                @Override
                public void bundleChanged(BundleEvent be) {
                    System.out.println("\n BundleChange" + be.getBundle().getSymbolicName() + "\n");
                }
            });

            cb.addServiceListener(new ServiceListener() {
                @Override
                public void serviceChanged(ServiceEvent se) {
                    System.out.println("\n ServiceChange" + se.getServiceReference().getBundle().getSymbolicName() + "\n");
                }
            });

            cb.addFrameworkListener(new FrameworkListener() {
                @Override
                public void frameworkEvent(FrameworkEvent fe) {
                    System.out.println("\n frameworkEvent" + fe.getBundle().getSymbolicName() + "\n");
                }
            });
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
