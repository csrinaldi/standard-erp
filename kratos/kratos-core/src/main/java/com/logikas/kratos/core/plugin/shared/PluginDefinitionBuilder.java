package com.logikas.kratos.core.plugin.shared;

public interface PluginDefinitionBuilder {
  
  PluginDefinitionBuilder definition(String name, String title);
  
  PluginDefinitionBuilder action(String name, String title, String image);
  
  PluginDefinitionBuilder place(String name, String title, String image);
  
  PluginDefinition build();
}
