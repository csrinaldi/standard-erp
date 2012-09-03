/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.shared;

/**
 * 
 * @author cristian
 */
public class Distribution {

  private final Plugin[] plugins;

  private final PluginRegistry registry;

  public Distribution(PluginRegistry registry, Plugin... plugins) {
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
