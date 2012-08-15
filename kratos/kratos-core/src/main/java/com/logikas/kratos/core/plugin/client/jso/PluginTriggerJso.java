package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.PluginTrigger;

import com.google.gwt.core.client.JavaScriptObject;

class PluginTriggerJso extends JavaScriptObject implements PluginTrigger {
  
  native static final PluginTriggerJso create(String name) /*-{
    return {name: name, token: null, title: null, icon: null, children: []};
  }-*/;

  protected PluginTriggerJso() {
  }

  @Override
  public native final String getName() /*-{
		return this.name;
  }-*/;

  @Override
  public native final String getToken() /*-{
		return this.token;
  }-*/;

  native final void setToken(String token) /*-{
		this.token = token;
  }-*/;

  @Override
  public native final String getIcon() /*-{
		return this.icon;
  }-*/;

  native final void setIcon(String icon) /*-{
		this.icon = icon;
  }-*/;

  @Override
  public native final String getTitle() /*-{
		return this.action;
  }-*/;

  native final void setTitle(String title) /*-{
		this.title = title;
  }-*/;
  
  native final void addChild(PluginTriggerJso child) /*-{
    this.children[this.children.length] = child;
  }-*/;
}
