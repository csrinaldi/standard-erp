/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.ioc;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.Singleton;
import com.logikas.kratos.core.module.Module;
import com.logikas.kratos.core.module.impl.CoreModule;
import com.logikas.kratos.core.osgi.WatcherCore;
import org.ops4j.peaberry.Export;
import static org.ops4j.peaberry.Peaberry.service;
import org.ops4j.peaberry.activation.util.PeaberryActivationModule;
import static org.ops4j.peaberry.util.TypeLiterals.export;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Class ActivationModule
 *
 * Este modulo configura la importacion y exportacion de componentes del modulo
 * core.
 *
 *
 * Package: com.logikas.kratos.core.ioc Last modification: 06/11/2012 File:
 * ActivationModule.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class ActivationModule extends PeaberryActivationModule {
    
    @Override
    protected void configure() {
        /* Export CoreModule*/
        bind(export(Module.class)).toProvider(service(CoreModule.class).export());
        bind(CoreModule.class).in(Singleton.class);

        /* Export Events */


        /* Bind Watcher */
        bind(WatcherCore.class).in(Singleton.class);
        bindService(Module.class).out(Key.get(WatcherCore.class)).multiple();


        /* Export EventBus */
        bind(EventBus.class).in(Singleton.class);
        bind(export(EventBus.class)).toProvider(service(EventBus.class).export());

        requestInjection(this);
    }
}
