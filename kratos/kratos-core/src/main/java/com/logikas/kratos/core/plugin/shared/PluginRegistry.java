/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.core.plugin.shared;

import com.logikas.kratos.core.plugin.shared.event.HasSubscriptionHandlers;
import com.logikas.kratos.core.plugin.shared.model.PluginDescription;

/**
 * 
 * @author cristian
 */
public interface PluginRegistry extends HasSubscriptionHandlers {

  void subscribe(PluginDescription description);
}
