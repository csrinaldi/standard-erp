package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.PluginTrigger;

import com.google.gwt.core.client.JavaScriptObject;

class PluginTriggerJso extends JavaScriptObject implements PluginTrigger {

  protected PluginTriggerJso() {    
  }
  
  public static native PluginTriggerJso create(String name, String title, String image) /*-{
    return {name: name, title: title, image: image};
  }-*/;
  
  @Override
  public native final String getName() /*-{
    return this.name;
  }-*/;
  
  @Override
  public native final String getImage() /*-{
    return this.image;
  }-*/;
  
  @Override
  public native final String getTitle() /*-{
    return this.action;
  }-*/;
}
