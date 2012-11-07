/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.module.event;

import com.logikas.kratos.core.module.Module;

/**
 * kratos Core OSGI Bundle
 *
 * Documentation of Class ModuleShutdownEvent
 *
 *
 * Package: com.logikas.kratos.core.module.event Last modification: 05/11/2012
 * File: ModuleShutdownEvent.java
 *
 * @author Cristian Rinaldi cristian.rinaldi@logikas.com Logikas - Conectando
 * Ideas.
 *
 */
public class ModuleShutdownEvent {

    private Module module;

    public ModuleShutdownEvent(Module module) {
        this.module = module;
    }

    public Module getModule() {
        return module;
    }
}
