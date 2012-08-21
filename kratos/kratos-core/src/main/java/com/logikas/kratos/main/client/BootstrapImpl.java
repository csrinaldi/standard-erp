/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.main.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.logikas.kratos.main.client.mvp.ActivityManagerInitializer;
import com.logikas.kratos.main.client.widget.LayoutWidget;
import javax.inject.Inject;

/**
 *
 * @author csrinaldi
 */
public class BootstrapImpl implements Bootstrap {

    private final LayoutWidget layoutWidget;
    private final PlaceHistoryHandler historyHandler;

    @Inject
    BootstrapImpl(PlaceHistoryHandler historyHandler, LayoutWidget layoutWidget, ActivityManagerInitializer initializer) {
        this.historyHandler = historyHandler;
        this.layoutWidget = layoutWidget;
    }

    @Override
    public void start() {
        RootLayoutPanel.get().add(layoutWidget.asWidget());
        this.historyHandler.handleCurrentHistory();
    }

    @Override
    public void loadModules() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
