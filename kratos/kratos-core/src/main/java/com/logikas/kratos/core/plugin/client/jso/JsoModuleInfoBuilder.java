/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.config.ModuleInfoBuilder;
import com.logikas.kratos.core.plugin.shared.model.MenuNode;
import com.logikas.kratos.core.plugin.shared.model.ModuleInfo;

/**
 *
 * @author cristian
 */
public class JsoModuleInfoBuilder implements ModuleInfoBuilder {

    private final JsoModuleInfo moduleInfo;

    JsoModuleInfoBuilder(JsoModuleInfo moduleInfo) {
        this.moduleInfo = moduleInfo;
    }

    protected final JsoModuleInfo getModuleInfo() {
        return moduleInfo;
    }
    
    public JsoModuleInfoBuilder(){
        this(JsoModuleInfo.create());
    }

    public ModuleInfoBuilder name(String name) {
        getModuleInfo().setName(name);
        return this;
    }

    public ModuleInfoBuilder version(String version) {
        getModuleInfo().setVersion(version);
        return this;
    }

    public ModuleInfoBuilder menu(MenuNode menu) {
        getModuleInfo().setMenuNode((JsoMenuNode)menu);
        return this;
    }
    
    public ModuleInfo moduleInfo(){
        return moduleInfo;
    }
}
