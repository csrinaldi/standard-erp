/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.osgi;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.logikas.kratos.core.module.Module;
import com.logikas.kratos.core.module.event.ModuleInitializedEvent;
import com.logikas.kratos.core.module.event.ModuleShutdownEvent;
import java.util.Map;
import org.ops4j.peaberry.Import;
import org.ops4j.peaberry.util.AbstractWatcher;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Class WatcherCore
 *
 *
 * Package: com.logikas.kratos.core.osgi Last modification: 06/11/2012 File:
 * WatcherCore.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class WatcherCore extends AbstractWatcher<Module> {

    private final EventBus eventBus;
    
    @Inject
    public WatcherCore(final EventBus eventBus) {
        System.out.println("\nCreando el Watcher\n");
        this.eventBus = eventBus;
    }

    @Override
    protected Module adding(Import<Module> service) {
        System.out.println("\nLanzando el Evento "+service.get().getName()+"\n");
        this.eventBus.post(new ModuleInitializedEvent(service.get()));
        return super.adding(service);
    }

    @Override
    protected void removed(Module instance) {
        System.out.println("\nLanzando el Evento "+instance.getName()+"\n");
        this.eventBus.post(new ModuleShutdownEvent(instance));
        super.removed(instance);
    }

    @Override
    protected void modified(Module instance, Map<String, ?> attributes) {
        System.out.print("\n" + instance.getName() + "is ADD\n");
        super.modified(instance, attributes);
    }
}
