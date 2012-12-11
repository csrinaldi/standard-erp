/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.osgi;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.logikas.kratos.client.ioc.ActivationModule;
import com.logikas.kratos.client.ioc.ServletModule;
import static org.ops4j.peaberry.Peaberry.osgiModule;
import org.osgi.framework.BundleActivator;
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

@Deprecated
public class OsgiActivator implements BundleActivator {

    @Override
    public void start(BundleContext bc) throws Exception {
        Injector injector;
        injector = Guice.createInjector(osgiModule(bc), new ServletModule(), new ActivationModule());

        injector.injectMembers(this);

        System.out.println(
                "\n**************************************************");
        System.out.println(
                "Start OsgiActivator");
        System.out.println(
                "**************************************************\n");


        if (bc != null) {

            bc.addBundleListener(new BundleListener() {
                @Override
                public void bundleChanged(BundleEvent be) {
                    System.out.println("\n Activator  BundleChange" + be.getBundle().getSymbolicName() + "\n");
                }
            });

            bc.addServiceListener(new ServiceListener() {
                @Override
                public void serviceChanged(ServiceEvent se) {
                    System.out.println("\n Activator ServiceChange" + se.getServiceReference().getBundle().getSymbolicName() + "\n");
                }
            });

            bc.addFrameworkListener(new FrameworkListener() {
                @Override
                public void frameworkEvent(FrameworkEvent fe) {
                    System.out.println("\n Activator  frameworkEvent" + fe.getBundle().getSymbolicName() + "\n");
                }
            });
            
            
        }


    }

    @Override
    public void stop(BundleContext bc) throws Exception {
    }
}
