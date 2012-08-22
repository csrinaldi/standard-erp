/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.main.client.manager;

import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceChangeRequestEvent;
import com.logikas.kratos.core.plugin.shared.model.ModuleInfo;

/**
 *
 * @author cristian
 */
public interface ViewManager extends PlaceChangeEvent.Handler, PlaceChangeRequestEvent.Handler{
    
   void registerModule(ModuleInfo info); 
    
}
