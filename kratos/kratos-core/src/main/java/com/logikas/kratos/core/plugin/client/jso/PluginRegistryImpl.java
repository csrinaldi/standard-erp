/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.client.jso;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.logikas.kratos.core.plugin.shared.PluginRegistry;
import com.logikas.kratos.core.plugin.shared.event.SubscriptionEvent;
import com.logikas.kratos.core.plugin.shared.event.SubscriptionHandler;
import com.logikas.kratos.core.plugin.shared.model.PluginDescription;

/**
 * 
 * @author cristian
 */
public class PluginRegistryImpl implements PluginRegistry {

  private final JsoPluginRegistry jsoRegistry;

  private final EventBus eventBus;

  public PluginRegistryImpl(EventBus eventBus, JsoPluginRegistry registry) {
    this.jsoRegistry = registry;
    this.eventBus = eventBus;

    this.jsoRegistry.addHandler(new JsoPluginRegistry.Handler() {
      @Override
      public void onSubscribe(JsoPluginDescription info) {
        SubscriptionEvent.fire(PluginRegistryImpl.this, info);
      }
    });
  }

  public PluginRegistryImpl(EventBus eventBus) {
    this(eventBus, JsoPluginRegistry.get("ModuleRegistry"));
  }

  public PluginRegistryImpl() {
    this(new SimpleEventBus());
  }

  @Override
  public void subscribe(PluginDescription moduleInfo) {
    jsoRegistry.subscribe(moduleInfo);
  }

  @Override
  public HandlerRegistration addSubscriptionHandler(SubscriptionHandler handler) {
    return eventBus.addHandler(SubscriptionEvent.getType(), handler);
  }

  @Override
  public void fireEvent(GwtEvent<?> event) {
    eventBus.fireEvent(event);
  }
}
