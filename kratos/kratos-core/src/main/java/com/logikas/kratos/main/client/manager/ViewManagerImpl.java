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
import com.google.web.bindery.event.shared.EventBus;

import javax.inject.Inject;

/**
 * 
 * @author cristian
 */
public class ViewManagerImpl implements ViewManager {

  @Inject
  public ViewManagerImpl(EventBus eventBus, PluginRegistry moduleRegistry) {
    moduleRegistry.addSubscriptionHandler(new SubscriptionHandler() {

      @Override
      public void onSubscription(SubscriptionEvent event) {
        processMenu(event.getDescription());
      }
    });

    eventBus.addHandler(PlaceChangeEvent.TYPE, this);
    eventBus.addHandler(PlaceChangeRequestEvent.TYPE, this);
  }

  protected void processMenu(PluginDescription info) {

  }

  @Override
  public void onPlaceChange(PlaceChangeEvent event) {
    GWT.log("onPlaceChange");
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
