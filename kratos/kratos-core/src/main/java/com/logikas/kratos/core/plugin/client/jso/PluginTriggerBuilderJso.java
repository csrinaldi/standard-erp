package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.PluginTriggerBuilder;

import com.google.gwt.core.client.JavaScriptObject;

public class PluginTriggerBuilderJso extends JavaScriptObject implements PluginTriggerBuilder {

  private final PluginTriggerJso asTrigger() {
    return this.cast();
  }
  
  @Override
  public final PluginTriggerBuilder token(String token) {
    asTrigger().setToken(token);
    return this;
  }

  @Override
  public PluginTriggerBuilder icon(String icon) {
    asTrigger().setIcon(icon);
    return this;
  }

  @Override
  public PluginTriggerBuilder child(String name) {
    final PluginTriggerBuilderJso child = create(name);
    asTrigger().addChild(child.asTrigger());
    return child;
  }

  static PluginTriggerBuilderJso create(String name) {
    return PluginTriggerJso.create(name).cast(); 
  }
}
