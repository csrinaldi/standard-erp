/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.client.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.logikas.kratos.core.plugin.shared.model.MenuNode;
import com.logikas.kratos.core.plugin.shared.model.ModuleInfo;

/**
 * 
 * @author cristian
 */
public class JsoModuleInfo extends JavaScriptObject implements ModuleInfo {

  native static final JsoModuleInfo create() /*-{
                                             return {};
                                             }-*/;

  protected JsoModuleInfo() {
  }

  @Override
  public native final MenuNode getMenuNode()/*-{
                                            return this.menu || null;
                                            }-*/;

  native final void setMenuNode(JsoMenuNode menu) /*-{
                                                  this.menu = menu;
                                                  }-*/;

  public native final String getName() /*-{
                                       return this.name || null;
                                       }-*/;

  native final void setName(String name) /*-{
                                         this.name = name;
                                         }-*/;

  public native final String getVersion() /*-{
                                          return this.version || null;
                                          }-*/;

  native final void setVersion(String version) /*-{
                                               this.version = version;
                                               }-*/;
}
