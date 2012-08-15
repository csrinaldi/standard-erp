package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.PluginDefinition;
import com.logikas.kratos.core.plugin.shared.PluginDefinitionBuilder;
import com.logikas.kratos.core.plugin.shared.PluginTriggerBuilder;

public class PluginDefinitionBuilderJso implements PluginDefinitionBuilder {

  private PluginDefinitionJso pluginDefinition;
  
  PluginDefinitionBuilderJso(String name) {
    initialize(name);    
  }
  
  private void initialize(String name) {
    this.pluginDefinition = PluginDefinitionJso.create(name);
  }
    
  @Override
  public PluginDefinitionBuilder title(String title) {
    pluginDefinition.setTitle(title);
    return this;
  }  
  
  @Override
  public PluginTriggerBuilder action(String name) {
    final PluginTriggerBuilderJso trigger = PluginTriggerBuilderJso.create(name);
    pluginDefinition.addActionTrigger(trigger.<PluginTriggerJso>cast());
    return trigger;    
  }

  @Override
  public PluginTriggerBuilder place(String name) {
    final PluginTriggerBuilderJso trigger = PluginTriggerBuilderJso.create(name);
    pluginDefinition.addPlaceTrigger(trigger.<PluginTriggerJso>cast());
    return trigger;
  }

  @Override
  public PluginDefinition build() {
    final PluginDefinition result = pluginDefinition;
    initialize(result.getName());    
    return result;
  }
}
