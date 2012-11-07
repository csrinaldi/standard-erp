package com.logikas.kratos.core.module.impl;

import com.google.common.eventbus.EventBus;
import com.google.inject.Inject;
import com.logikas.kratos.core.module.Module;
import com.logikas.kratos.core.module.event.ModuleShutdownEvent;
import org.ops4j.peaberry.activation.Start;
import org.ops4j.peaberry.activation.Stop;

/**
 *
 * 
 * kratos Core OSGI Bundle
 *
 * Documentation of Class CoreModule
 * 
 * Este representa al Core. Es el encargado de inicializar y detener el modulo
 * 
 *
 *
 * Package: com.logikas.kratos.core.module.impl 
 * Last modification: 06/11/2012
 * File: CoreModule.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */

public class CoreModule implements Module{

    @Inject
    Iterable<Module> modules;
    
    private Boolean active;
    private final EventBus eventBus;
    
    @Inject
    public CoreModule(final EventBus eventBus) {
        this.eventBus = eventBus;
    }
    
    @Override
    public String getName() {
        return this.getClass().getCanonicalName();
    }

    @Override
    @Start
    public Boolean initialize() {
        this.active = true;
        return this.active;
    }

    @Override
    public Boolean isActive() {
        return this.active;
    }

    @Override
    @Stop
    public Boolean shutdown() {
        this.active = false;
        this.eventBus.post(new ModuleShutdownEvent(this));
        return this.active;
    }
    
}
