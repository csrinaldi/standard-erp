/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.security.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.logikas.kratos.core.plugin.shared.Plugin;
import com.logikas.kratos.core.plugin.shared.model.PluginDescription;

/**
 * 
 * @author cristian
 */
public class SecurityPlugin implements Plugin {

  public void boot() {

  }

  public void shutdown() {

  }

  public PluginDescription getDescription() {
    return null;
  }

    @Override
    public PlaceHistoryMapper getHistoryMapper() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
