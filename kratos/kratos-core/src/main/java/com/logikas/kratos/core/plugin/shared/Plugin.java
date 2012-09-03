/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.shared;

import com.logikas.kratos.core.plugin.shared.model.PluginDescription;

/**
 * 
 * @author cristian
 */
public interface Plugin {

  void boot();

  void shutdown();

  PluginDescription getDescription();
}
