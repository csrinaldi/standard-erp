/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.main.client.manager;

import com.logikas.kratos.core.plugin.shared.PluginRegistry;
import com.logikas.kratos.core.plugin.shared.event.SubscriptionEvent;
import com.logikas.kratos.core.plugin.shared.event.SubscriptionHandler;
import com.logikas.kratos.core.plugin.shared.model.PluginDescription;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceChangeRequestEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.logikas.kratos.main.client.view.LayoutView;

import javax.inject.Inject;

/**
 * 
 * @author cristian
 */
public class ViewManagerImpl implements ViewManager {

  private LayoutView layout;
  private VerticalPanel menuPanel;
    
  @Inject
  public ViewManagerImpl(LayoutView view, EventBus eventBus, PluginRegistry moduleRegistry) {
    eventBus.addHandler(PlaceChangeEvent.TYPE, this);
    eventBus.addHandler(PlaceChangeRequestEvent.TYPE, this);
    
    this.layout = view;

    menuPanel = new VerticalPanel();
    view.getWestRegion().setWidget(menuPanel);
    
    moduleRegistry.addSubscriptionHandler(new SubscriptionHandler() {

      @Override
      public void onSubscription(SubscriptionEvent event) {
        processMenu(event.getDescription());
      }
    });
    
    
  }

  protected void processMenu(PluginDescription info) {

  }

  @Override
  public void onPlaceChange(PlaceChangeEvent event) {
      //TODO ver otras condiciones graficas
      this.layout.setDefaultLayout();
  }

  @Override
  public void onPlaceChangeRequest(PlaceChangeRequestEvent event) {

    // Evaluar el place

    GWT.log("onPlaceChangeRequest");
    GWT.log(event.getNewPlace().toString());
  }

  @Override
  public void registerModule(PluginDescription info) {

  }

}
