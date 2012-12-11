/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.core.module.event;

import com.google.common.eventbus.EventBus;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Class EventDispatcherImpl
 *
 *
 * Package: com.logikas.kratos.core.module.event 
 * Last modification: 20/11/2012
 * File: EventDispatcherImpl.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public class EventDispatcherImpl implements EventDispatcher{

    private EventBus bus = new EventBus();
    
    @Override
    public void post(Object object) {
        System.out.println("Lanzando Evento "+object+"...\n");
        bus.post(object);
    }
    
    @Override
    public void register(Object object){
        System.out.println("Registrando ...\n");
        bus.register(object);
    }
    
    @Override
    public void unregister(Object object){
        bus.unregister(object);
    }
}
