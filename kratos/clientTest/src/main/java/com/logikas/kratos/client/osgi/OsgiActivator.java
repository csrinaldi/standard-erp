/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.osgi;

import com.logikas.kratos.client.ioc.GuiceFactory;
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
        GuiceFactory.getInjector().injectMembers(osgiModule(bc));
    }

    @Override
    public void stop(BundleContext bc) throws Exception {
        
    }
    
}
