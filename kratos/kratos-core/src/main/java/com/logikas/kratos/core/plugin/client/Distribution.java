/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author cristian
 */
public class Distribution{
    
    private Plugin[] plugins;

    private ModuleRegistry registry;
    
    public Distribution(ModuleRegistry registry, Plugin... plugins) {
        this.registry = registry;
        this.plugins = plugins;
    }
    
    public void start() {
        for (Plugin plugin : plugins) {
            registry.subscribe(plugin.getDescription());
            plugin.boot();
            
        }
    }
}
