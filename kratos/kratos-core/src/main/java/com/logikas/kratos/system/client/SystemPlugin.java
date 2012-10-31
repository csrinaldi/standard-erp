/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.system.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.logikas.kratos.core.plugin.client.jso.JsoMenuNodeBuilder;
import com.logikas.kratos.core.plugin.client.jso.JsoPluginDescriptionBuilder;
import com.logikas.kratos.core.plugin.shared.Plugin;
import com.logikas.kratos.core.plugin.shared.model.PluginDescription;
import com.logikas.kratos.core.ui.client.LayoutView;
import com.logikas.kratos.system.client.mvp.SystemActivityManager;
import com.logikas.kratos.system.client.mvp.SystemPlaceHistoryMapper;
import com.logikas.kratos.system.shared.place.CreateUserPlace;
import com.logikas.kratos.system.shared.place.SearchUserPlace;
import javax.inject.Named;

/**
 *
 * @author cristian
 */
public class SystemPlugin implements Plugin {
 
    private final PlaceController placeController;
  
    private final SystemActivityManager activityManager;
    
    private final SystemPlaceHistoryMapper historyMapper;
    
    private final EventBus eventBus;
    
    private final LayoutView view;

    @Inject
    public SystemPlugin(SystemPlaceHistoryMapper historyMapper, PlaceHistoryHandler handler, PlaceController placeController, SystemActivityManager activityManager, LayoutView view, EventBus eventBus) {
        this.activityManager = activityManager;
        this.view = view;
        this.placeController = placeController;
        this.eventBus = eventBus;
        this.historyMapper = historyMapper;
                
    }

    @Override
    public void boot() {
        activityManager.setDisplay(view.getCenterRegion());
    }

    @Override
    public void shutdown() {
    }

    @Override
    public PluginDescription getDescription() {
        String token = historyMapper.getToken(new CreateUserPlace());
        String tokenSearch = historyMapper.getToken(new SearchUserPlace());

        final JsoMenuNodeBuilder nodeBuilder = new JsoMenuNodeBuilder();
        nodeBuilder.title("System");
        nodeBuilder.tooltip("Módulo de Sistema");
        nodeBuilder.token(token);
        
        final JsoMenuNodeBuilder nodeBuilderSearch = new JsoMenuNodeBuilder();
        nodeBuilderSearch.title("Search");
        nodeBuilderSearch.tooltip("Módulo de Sistema - Busquedas");
        nodeBuilderSearch.token(tokenSearch);
        
        //nodeBuilder.child("Submenu", nodeBuilderSearch.menuNode());
        

        final JsoPluginDescriptionBuilder builder = new JsoPluginDescriptionBuilder();
        builder.name("system");
        builder.version("1.0");
        builder.menu(nodeBuilder.menuNode());
        return builder.getDescription();
    }

    @Override
    public PlaceHistoryMapper getHistoryMapper() {
        return this.historyMapper;
    }
}
