package com.logikas.kratos.core.plugin.shared;

public interface PluginDefinitionBuilder {
  
  PluginDefinitionBuilder title(String title);
  
  PluginTriggerBuilder action(String name);
  
  PluginTriggerBuilder place(String name);
  
  PluginDefinition build();
}
