package com.logikas.core.security.osgi;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Inject;
import com.logikas.core.security.ioc.OsgiModule;
import com.logikas.kratos.core.module.Module;
import org.ops4j.peaberry.Export;
import static org.ops4j.peaberry.Peaberry.osgiModule;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class SecurityActivator implements BundleActivator {

    @Inject
    Export<Module> handlerModule;
    
    @Override
    public void start(BundleContext bc) throws Exception {
        createInjector(osgiModule(bc), new OsgiModule()).injectMembers(this);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        handlerModule.unput();
    }

}
