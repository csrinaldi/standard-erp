/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.client.event;

import com.google.common.eventbus.Subscribe;
import com.logikas.kratos.core.module.event.ModuleInitializeEventHandler;
import com.logikas.kratos.core.module.event.ModuleInitializedEvent;

/**
 *
 * @author Cristian Rinaldi
 */
public class ModuleInitializeEventHandlerImpl implements ModuleInitializeEventHandler{

    @Override
    @Subscribe
    public void handle(ModuleInitializedEvent event) {
        System.out.println(event.getModule().getName() + "IS INITIALIZED");
    }
    
}
