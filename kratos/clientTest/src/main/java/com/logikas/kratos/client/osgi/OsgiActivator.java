/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.osgi;

import com.google.inject.Guice;
import com.google.inject.servlet.GuiceFilter;
import com.logikas.kratos.client.ioc.GuiceFactory;
import com.logikas.kratos.client.ioc.ImportModule;
import com.logikas.kratos.client.ioc.ServletModule;
import static org.ops4j.peaberry.Peaberry.osgiModule;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 *
 * @author cristian
 */
public class OsgiActivator implements BundleActivator{

    @Override
    public void start(BundleContext bc) throws Exception {
        //GuiceFilter guiceFilter = .getInstance( GuiceFilter.class );
        Guice.createInjector( osgiModule( bc ), new ServletModule() );
        //GuiceFactory.getInjector().injectMembers(osgiModule(bc));
    }

    @Override
    public void stop(BundleContext bc) throws Exception {
        
    }
    
}
