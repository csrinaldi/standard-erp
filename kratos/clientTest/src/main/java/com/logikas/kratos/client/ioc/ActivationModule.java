/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.ioc;

import com.google.common.eventbus.EventBus;
import com.google.inject.Singleton;
import com.logikas.kratos.client.module.ClientModule;
import com.logikas.kratos.core.module.Module;
import com.logikas.kratos.core.module.event.ModuleInitializeEventHandler;
import org.ops4j.peaberry.activation.util.PeaberryActivationModule;
import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.TypeLiterals.iterable;

/**
 *
 * @author cristian
 */
public class ActivationModule extends PeaberryActivationModule {

    @Override
    protected void configure() {
        
        bind(ClientModule.class).in(Singleton.class);

        bind(iterable(Module.class)).toProvider(service(Module.class).multiple());
        
        bind(EventBus.class).toProvider(service(EventBus.class).single());
        
        //bind(ModuleInitializeEventHandler.class).toProvider(service(ModuleInitializeEventHandler.class).single());

        install(new ServletModule());
        
        requestInjection(this);
    }
}
