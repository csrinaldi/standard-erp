package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.PluginDefinition;
import com.logikas.kratos.core.plugin.shared.PluginTriggerList;

import com.google.gwt.core.client.JavaScriptObject;

class PluginDefinitionJso extends JavaScriptObject implements PluginDefinition {

  protected PluginDefinitionJso() {
  }
  
  public native static PluginDefinitionJso create(String name, String title) /*-{
    return {name: name, title: title, actionTriggers: [], placeTriggers: []};
  }-*/;

  @Override
  public native final String getName() /*-{
		return this.name;
  }-*/;

  @Override
  public native final String getTitle() /*-{
		return this.title;
  }-*/;

  @Override
  public native final PluginTriggerList getActionTriggers() /*-{
		return this.actionTriggers;
  }-*/;

  native final void addActionTrigger(PluginTriggerJso trigger) /*-{
		var actionTriggers = this.actionTriggers;
		actionTriggers[actionTriggers.length] = trigger;
  }-*/;

  @Override
  public native final PluginTriggerList getPlaceTriggers() /*-{
		return this.placeTriggers;
  }-*/;

  native final void addPlaceTrigger(PluginTriggerJso trigger) /*-{
		var placeTriggers = this.placeTriggers;
		placeTriggers[placeTriggers.length] = trigger;
  }-*/;
}
