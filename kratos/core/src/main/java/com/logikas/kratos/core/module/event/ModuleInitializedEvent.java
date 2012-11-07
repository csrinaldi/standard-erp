/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.core.module.event;

import com.logikas.kratos.core.module.Module;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Class ModuleInitializedEvent
 *
 *
 * Package: com.logikas.kratos.core.module.event 
 * Last modification: 05/11/2012
 * File: ModuleInitializedEvent.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public class ModuleInitializedEvent {
    
    private Module module;

    public ModuleInitializedEvent(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }
}
