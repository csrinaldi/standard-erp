/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.event;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Singleton;
import com.logikas.kratos.core.module.event.ModuleInitializeEventHandler;
import com.logikas.kratos.core.module.event.ModuleInitializedEvent;

/**
 *
 * @author Cristian Rinaldi
 */
@Singleton
public class ModuleInitializeEventHandlerImpl implements ModuleInitializeEventHandler{

    @Override
    @Subscribe
    public void handle(ModuleInitializedEvent event) {
        System.out.println("\n" + event.getModule().getName() + "IS INITIALIZED\n");
    }
    
}
