/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.osgi;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Inject;
import com.logikas.kratos.core.ioc.ActivationModule;
import com.logikas.kratos.core.module.Module;
import org.ops4j.peaberry.Export;
import static org.ops4j.peaberry.Peaberry.osgiModule;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 *
 * @author cristian
 * @deprecated @see ActivationModule
 */
public class CoreActivator implements BundleActivator{

    @Inject
    Export<Module> hanlde;

    @Override
    public void start(BundleContext bc) throws Exception {
        createInjector(osgiModule(bc), new ActivationModule()).injectMembers(this);
    }

    @Override
    public void stop(BundleContext bc) throws Exception {
        hanlde.unput();
    }
    
}
