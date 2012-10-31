/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.shared;

import com.logikas.kratos.core.plugin.shared.place.DispatchedHistoryMapper;

/**
 * 
 * @author cristian
 */
public class Distribution {

  private final Plugin[] plugins;

  private final PluginRegistry registry;
  
  private final DispatchedHistoryMapper historyMapper;

  public Distribution(PluginRegistry registry, DispatchedHistoryMapper mapper, Plugin... plugins) {
    this.registry = registry;
    this.plugins = plugins;
    this.historyMapper = mapper;
  }

  public void start() {
    for (Plugin plugin : plugins) {
      registry.subscribe(plugin.getDescription());
      historyMapper.register(plugin.getHistoryMapper());
      plugin.boot();
    }
  }
}
