/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.ioc;

import com.google.inject.Key;
import com.google.inject.Singleton;
import com.logikas.kratos.client.osgi.Watcher;
import com.logikas.kratos.core.module.Module;
import org.ops4j.peaberry.activation.util.PeaberryActivationModule;

/**
 *
 * @author cristian
 */
public class ActivationModule extends PeaberryActivationModule {

    @Override
    protected void configure() {
        bind(Watcher.class).in(Singleton.class);
        
        bindService(Module.class).multiple();
        bindService(Module.class).out(Key.get(Watcher.class)).multiple();
        
        requestInjection(this);
        
        //install(new ServletModule());
    }
}
