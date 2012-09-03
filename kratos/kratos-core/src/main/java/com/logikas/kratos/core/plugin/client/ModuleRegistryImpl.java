/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.client;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.logikas.kratos.core.plugin.client.jso.JsoModuleInfo;
import com.logikas.kratos.core.plugin.shared.event.SubscriptionEvent;
import com.logikas.kratos.core.plugin.shared.event.SubscriptionHandler;
import com.logikas.kratos.core.plugin.shared.model.ModuleInfo;

/**
 * 
 * @author cristian
 */
public class ModuleRegistryImpl implements ModuleRegistry {

  private final JsoModuleRegistry jsoRegistry;

  private final EventBus eventBus;

  public ModuleRegistryImpl(EventBus eventBus, JsoModuleRegistry registry) {
    this.jsoRegistry = registry;
    this.eventBus = eventBus;

    this.jsoRegistry.addHandler(new JsoModuleRegistry.Handler() {
      @Override
      public void onSubscribe(JsoModuleInfo info) {
        SubscriptionEvent.fire(ModuleRegistryImpl.this, info);
      }
    });
  }

  public ModuleRegistryImpl(EventBus eventBus) {
    this(eventBus, JsoModuleRegistry.get());
  }

  public ModuleRegistryImpl() {
    this(new SimpleEventBus());
  }

  @Override
  public void subscribe(ModuleInfo moduleInfo) {
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
