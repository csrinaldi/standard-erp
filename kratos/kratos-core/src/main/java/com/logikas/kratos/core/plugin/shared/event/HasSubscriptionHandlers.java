/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.shared.event;

import com.google.gwt.event.shared.HasHandlers;
import com.google.web.bindery.event.shared.HandlerRegistration;

/**
 * 
 * @author cristian
 */
public interface HasSubscriptionHandlers extends HasHandlers {

  HandlerRegistration addSubscriptionHandler(SubscriptionHandler handler);

}
