/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.main.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceChangeRequestEvent;
import javax.inject.Inject;

import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.logikas.kratos.main.client.manager.ViewManager;
import com.logikas.kratos.main.client.mvp.ActivityManagerInitializer;
import com.logikas.kratos.main.client.widget.LayoutWidget;

/**
 *
 * @author csrinaldi
 */
public class BootstrapImpl implements Bootstrap{

    private final LayoutWidget layoutWidget;
    private final PlaceHistoryHandler historyHandler;
    private final ViewManager viewManager;

    @Inject
    BootstrapImpl(PlaceHistoryHandler historyHandler, ViewManager viewManager, LayoutWidget layoutWidget, ActivityManagerInitializer initializer) {
        this.historyHandler = historyHandler;
        this.layoutWidget = layoutWidget;
        this.viewManager = viewManager;
    }

    @Override
    public void start() {
        RootLayoutPanel.get().add(layoutWidget.asWidget());
        this.historyHandler.handleCurrentHistory();
    }
}
