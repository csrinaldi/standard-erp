/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.main.client.manager;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceChangeRequestEvent;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.logikas.kratos.core.plugin.client.ModuleRegistry;
import com.logikas.kratos.core.plugin.shared.event.SubscriptionEvent;
import com.logikas.kratos.core.plugin.shared.event.SubscriptionHandler;
import com.logikas.kratos.core.plugin.shared.model.ModuleInfo;
import java.util.Map;
import javax.inject.Inject;

/**
 *
 * @author cristian
 */
public class ViewManagerImpl implements ViewManager{
    
    @Inject
    public ViewManagerImpl(EventBus eventBus, ModuleRegistry moduleRegistry ) {
        moduleRegistry.addSubscriptionHandler(new SubscriptionHandler() {

            @Override
            public void onSubscription(SubscriptionEvent event) {
                processMenu(event.getModuleInfo());
            }
        });
        
        eventBus.addHandler(PlaceChangeEvent.TYPE, this);
        eventBus.addHandler(PlaceChangeRequestEvent.TYPE, this);
    }
    
    protected void processMenu(ModuleInfo info){
        Window.alert("Estamos procesando el puto menu " + info.getMenuNode().getTitle() );
    }

    @Override
    public void onPlaceChange(PlaceChangeEvent event) {
        GWT.log("onPlaceChange");
    }

    @Override
    public void onPlaceChangeRequest(PlaceChangeRequestEvent event) {
        
        //Evaluar el place
        
        GWT.log("onPlaceChangeRequest");
        GWT.log(event.getNewPlace().toString());
    }

    @Override
    public void registerModule(ModuleInfo info) {
        
    }
    
}
