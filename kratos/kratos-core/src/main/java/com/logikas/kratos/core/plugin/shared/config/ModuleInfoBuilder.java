/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.shared.config;

import com.logikas.kratos.core.plugin.shared.model.MenuNode;

/**
 * 
 * @author cristian
 */
public interface ModuleInfoBuilder {

  ModuleInfoBuilder name(String name);

  ModuleInfoBuilder version(String version);

  ModuleInfoBuilder menu(MenuNode menu);

}
