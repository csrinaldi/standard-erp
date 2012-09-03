/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.main.client;

import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.logikas.kratos.core.plugin.client.Plugin;
import com.logikas.kratos.core.plugin.client.jso.JsoMenuNodeBuilder;
import com.logikas.kratos.core.plugin.client.jso.JsoModuleInfoBuilder;
import com.logikas.kratos.core.plugin.shared.model.ModuleInfo;
import com.logikas.kratos.main.client.manager.ViewManager;
import com.logikas.kratos.main.client.mvp.ActivityManagerInitializer;
import com.logikas.kratos.main.client.widget.LayoutWidget;
import javax.inject.Inject;

/**
 * 
 * @author cristian
 */
public class MainPlugin implements Plugin {

  private final LayoutWidget layoutWidget;
  private final PlaceHistoryHandler historyHandler;
  private final ViewManager viewManager;

  @Inject
  MainPlugin(PlaceHistoryHandler historyHandler, ViewManager viewManager,
      LayoutWidget layoutWidget, ActivityManagerInitializer initializer) {
    this.historyHandler = historyHandler;
    this.layoutWidget = layoutWidget;
    this.viewManager = viewManager;
  }

  public void boot() {
    RootLayoutPanel.get().add(layoutWidget.asWidget());
    this.historyHandler.handleCurrentHistory();

  }

  public void shutdown() {
  }

  public ModuleInfo getDescription() {

    final JsoMenuNodeBuilder nodeBuilder = new JsoMenuNodeBuilder();
    nodeBuilder.title("Main");

    final JsoModuleInfoBuilder builder = new JsoModuleInfoBuilder();
    builder.name("main");
    builder.version("1.0");
    builder.menu(nodeBuilder.menuNode());
    return builder.moduleInfo();
  }
}
