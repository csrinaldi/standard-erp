package com.logikas.modernui.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.logikas.modernui.client.ui.MetroUiExample;
import com.logikas.modernui.client.ui.config.ResourceInjector;

/**
 * Entry point classes define
 * <code>onModuleLoad()</code>.
 */
public class ModernUi implements EntryPoint {

    public void onModuleLoad() {
        
        ResourceInjector.configure();
        
        RootPanel.get().add(new MetroUiExample());
        
    }
}
