/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.module;

import com.google.common.eventbus.EventBus;
import com.logikas.kratos.core.module.Module;
import com.logikas.kratos.core.module.event.EventDispatcher;
import com.logikas.kratos.core.module.event.ModuleInitializedEvent;
import com.logikas.kratos.core.module.impl.CoreModule;
import javax.inject.Inject;
import org.ops4j.peaberry.activation.Start;

/**
 * cdi-client
 *
 * Documentation of Class ClientModule
 *
 *
 * Package: com.logikas.kratos.client.module Last modification: 06/11/2012 File:
 * ClientModule.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class ClientModule implements Module {
    
    private final CoreModule module;
    private final EventDispatcher eventBus;
       
    
    @Inject
    public ClientModule(CoreModule coreModule, EventDispatcher eventBus) {
        this.module = coreModule;
        this.eventBus = eventBus;
    }
    
    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    @Start
    public Boolean initialize() {
        System.out.print("\nEsta ?"+this.module.toString()+"\n");
        this.eventBus.post(new ModuleInitializedEvent(this));
        return true;
    }

    @Override
    public Boolean isActive() {
        return true;
    }

    @Override
    public Boolean shutdown() {
        return true;
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
