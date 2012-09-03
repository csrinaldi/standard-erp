/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.shared.config;

import com.logikas.kratos.core.plugin.shared.model.MenuNode;

/**
 * 
 * @author cristian
 */
public interface PluginDescriptionBuilder {

  PluginDescriptionBuilder name(String name);

  PluginDescriptionBuilder version(String version);

  PluginDescriptionBuilder menu(MenuNode menu);

}
