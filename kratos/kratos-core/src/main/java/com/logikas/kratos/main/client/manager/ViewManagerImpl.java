/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.main.client.manager;

import com.logikas.kratos.core.plugin.shared.PluginRegistry;
import com.logikas.kratos.core.plugin.shared.event.SubscriptionEvent;
import com.logikas.kratos.core.plugin.shared.event.SubscriptionHandler;
import com.logikas.kratos.core.plugin.shared.model.PluginDescription;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceChangeRequestEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.web.bindery.event.shared.EventBus;
import com.logikas.kratos.main.client.view.LayoutView;
import com.logikas.kratos.main.shared.place.DefaultPlace;
import com.logikas.kratos.main.shared.place.MainPlaceHistoryMapper;

import javax.inject.Inject;

/**
 *
 * @author cristian
 */
public class ViewManagerImpl implements ViewManager {

    private LayoutView layout;
    private VerticalPanel menuPanel;
    private final MainPlaceHistoryMapper historyMapper;

    @Inject
    public ViewManagerImpl(MainPlaceHistoryMapper historyMapper, LayoutView view, EventBus eventBus, PluginRegistry moduleRegistry) {
        this.historyMapper = historyMapper;

        eventBus.addHandler(PlaceChangeEvent.TYPE, this);
        eventBus.addHandler(PlaceChangeRequestEvent.TYPE, this);

        this.layout = view;

        //TODO hacer un panel de Widgets de Menu
        menuPanel = new VerticalPanel();
        this.layout.getWestRegion().setWidget(menuPanel);


        moduleRegistry.addSubscriptionHandler(new SubscriptionHandler() {

            @Override
            public void onSubscription(SubscriptionEvent event) {
                processMenu(event.getDescription());
            }
        });
    }

    protected void processMenu(PluginDescription info) {
        SafeHtmlBuilder htmlBuilder = new SafeHtmlBuilder();
        htmlBuilder.appendEscaped(info.getMenuNode().getTitle());

        String token = info.getMenuNode().getToken();
        if (token == null) {
            token = this.historyMapper.getToken(new DefaultPlace());
        }

        Hyperlink link = new Hyperlink(htmlBuilder.toSafeHtml(), token);
        menuPanel.add(link);
    }

    @Override
    public void onPlaceChange(PlaceChangeEvent event) {
        //TODO ver otras condiciones graficas
      /*
         * if ( event.getNewPlace() instanceof DefaultPlace )
        this.layout.setDefaultLayout();
         */
    }

    @Override
    public void onPlaceChangeRequest(PlaceChangeRequestEvent event) {
        this.layout.setDefaultLayout();
    }
}
