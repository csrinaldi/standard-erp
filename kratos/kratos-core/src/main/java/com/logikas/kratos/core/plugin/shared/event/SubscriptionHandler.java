/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.shared.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author cristian
 */
public interface SubscriptionHandler extends EventHandler {

  void onSubscription(SubscriptionEvent event);

}
