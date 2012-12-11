/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.ioc;

import com.google.common.eventbus.EventBus;
import com.google.inject.Singleton;
import com.logikas.kratos.client.module.ClientModule;
import com.logikas.kratos.core.module.Module;
import com.logikas.kratos.core.module.event.CoreEventBus;
import com.logikas.kratos.core.module.event.EventDispatcher;
import com.logikas.kratos.core.module.impl.CoreModule;
import org.ops4j.peaberry.activation.util.PeaberryActivationModule;
import static org.ops4j.peaberry.Peaberry.service;

/**
 *
 * @author cristian
 */
public class ActivationModule extends PeaberryActivationModule {

    @Override
    protected void configure() {
        //bind(iterable(Module.class)).toProvider(service(Module.class).multiple());
        
        bind(EventDispatcher.class).toProvider(service(EventDispatcher.class).single());
        //bindService(EventBus.class).single();
        
        //bind(CoreModule.class).toProvider(service(CoreModule.class).single());
        
        bind(Module.class).toProvider(service(CoreModule.class).single());
        
        bind(ClientModule.class).in(Singleton.class);
        
        //bind(ModuleInitializeEventHandler.class).toProvider(service(ModuleInitializeEventHandler.class).single());

        install(new ServletModule());
        
        requestInjection(this);
    }
}
