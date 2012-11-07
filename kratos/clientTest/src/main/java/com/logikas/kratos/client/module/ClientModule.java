/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.module;

import com.google.common.eventbus.EventBus;
import com.logikas.kratos.client.event.ModuleInitializeEventHandlerImpl;
import com.logikas.kratos.core.module.Module;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.ops4j.peaberry.ServiceUnavailableException;
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

    @Inject
    EventBus eventBus;
    
    @Singleton
    private ModuleInitializeEventHandlerImpl handler = new ModuleInitializeEventHandlerImpl();

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    @Start
    public Boolean initialize() {

        this.eventBus.register(handler);

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
}
