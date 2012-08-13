package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.PluginDefinition;
import com.logikas.kratos.core.plugin.shared.PluginDefinitionBuilder;

public class PluginDefinitionBuilderJso implements PluginDefinitionBuilder {

  private PluginDefinitionJso pluginDefinition;
  
  @Override
  public PluginDefinitionBuilder definition(String name, String title) {
    pluginDefinition = PluginDefinitionJso.create(name, title);
    return this;
  }  
  
  @Override
  public PluginDefinitionBuilder action(String name, String title, String image) {
    pluginDefinition.addActionTrigger(PluginTriggerJso.create(name, title, image));
    return this;
  }

  @Override
  public PluginDefinitionBuilder place(String name, String title, String image) {
    pluginDefinition.addPlaceTrigger(PluginTriggerJso.create(name, title, image));
    return this;
  }

  @Override
  public PluginDefinition build() {
    final PluginDefinition result = pluginDefinition;
    pluginDefinition = null;
    return result;
  }
}
