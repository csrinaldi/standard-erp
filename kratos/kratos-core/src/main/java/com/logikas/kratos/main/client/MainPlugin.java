/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.main.client;

import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.logikas.kratos.core.plugin.client.jso.JsoMenuNodeBuilder;
import com.logikas.kratos.core.plugin.client.jso.JsoPluginDescriptionBuilder;
import com.logikas.kratos.core.plugin.shared.Plugin;
import com.logikas.kratos.core.plugin.shared.model.PluginDescription;
import com.logikas.kratos.main.client.manager.ViewManager;
import com.logikas.kratos.main.client.mvp.MainCenterActivityManager;
import com.logikas.kratos.core.ui.client.LayoutView;
import com.logikas.kratos.main.shared.place.DashboardPlace;
import com.logikas.kratos.main.shared.place.MainPlaceHistoryMapper;
import javax.inject.Inject;

/**
 *
 * @author cristian
 */
public class MainPlugin implements Plugin {

    private final LayoutView layoutWidget;
    private final PlaceHistoryHandler historyHandler;
    private final ViewManager viewManager;
    private final MainPlaceHistoryMapper historyMapper;
    private final MainCenterActivityManager centerActivityManager;

    @Inject
    MainPlugin(MainCenterActivityManager centerActivityManager, MainPlaceHistoryMapper historyMapper, PlaceHistoryHandler historyHandler, ViewManager viewManager,
            LayoutView layoutWidget) {
        
        this.historyHandler = historyHandler;
        this.layoutWidget = layoutWidget;
        this.viewManager = viewManager;
        this.historyMapper = historyMapper;
        this.centerActivityManager = centerActivityManager;
    }

    @Override
    public void boot() {
        RootLayoutPanel.get().add(layoutWidget.asWidget());
        centerActivityManager.setDisplay(layoutWidget.getNorthRegion());
        this.historyHandler.handleCurrentHistory();
    }

    @Override
    public void shutdown() {
    }

    @Override
    public PluginDescription getDescription() {
        
        String token = historyMapper.getToken(new DashboardPlace());

        final JsoMenuNodeBuilder nodeBuilder = new JsoMenuNodeBuilder();
        nodeBuilder.title("Main");
        nodeBuilder.token(token);

        final JsoPluginDescriptionBuilder builder = new JsoPluginDescriptionBuilder();
        builder.name("main");
        builder.version("1.0");
        builder.menu(nodeBuilder.menuNode());
        return builder.getDescription();
    }

    @Override
    public PlaceHistoryMapper getHistoryMapper() {
        return this.historyMapper;
    }
}
