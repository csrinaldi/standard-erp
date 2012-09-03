/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.shared.event;

import com.logikas.kratos.core.plugin.shared.model.PluginDescription;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @author cristian
 */
public class SubscriptionEvent extends GwtEvent<SubscriptionHandler> {

  private static Type<SubscriptionHandler> TYPE = null;

  private final PluginDescription description;

  public static void fire(HasSubscriptionHandlers source, PluginDescription info) {
    source.fireEvent(new SubscriptionEvent(info));
  }

  protected SubscriptionEvent(PluginDescription description) {
    this.description = description;
  }

  @Override
  public Type<SubscriptionHandler> getAssociatedType() {
    return getType();
  }

  @Override
  protected void dispatch(SubscriptionHandler handler) {
    handler.onSubscription(this);
  }

  public static Type<SubscriptionHandler> getType() {
    if (TYPE == null) {
      TYPE = new Type<SubscriptionHandler>();
    }
    return TYPE;
  }

  public PluginDescription getDescription() {
    return description;
  }
}
