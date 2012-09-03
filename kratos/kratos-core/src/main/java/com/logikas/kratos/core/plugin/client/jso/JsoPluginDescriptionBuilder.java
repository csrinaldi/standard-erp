/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.client.jso;

import com.logikas.kratos.core.plugin.shared.config.PluginDescriptionBuilder;
import com.logikas.kratos.core.plugin.shared.model.MenuNode;
import com.logikas.kratos.core.plugin.shared.model.PluginDescription;

/**
 * 
 * @author cristian
 */
public class JsoPluginDescriptionBuilder implements PluginDescriptionBuilder {

  private final JsoPluginDescription description;

  JsoPluginDescriptionBuilder(JsoPluginDescription description) {
    this.description = description;
  }

  protected final JsoPluginDescription getJsoDescription() {
    return description;
  }

  public JsoPluginDescriptionBuilder() {
    this(JsoPluginDescription.create());
  }

  public PluginDescriptionBuilder name(String name) {
    getJsoDescription().setName(name);
    return this;
  }

  public PluginDescriptionBuilder version(String version) {
    getJsoDescription().setVersion(version);
    return this;
  }

  public PluginDescriptionBuilder menu(MenuNode menu) {
    getJsoDescription().setMenuNode((JsoMenuNode) menu);
    return this;
  }

  public PluginDescription getDescription() {
    return description;
  }
}
