/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.main.client.mvp.presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Provider;
import com.logikas.kratos.main.client.view.DashboardView;
import elemental.client.Browser;
import javax.inject.Inject;

/**
 *
 * @author cristian
 */
public class DashboardActivity extends AbstractActivity{

    
    @Inject
    private Provider<DashboardView> dashboardView;
    
    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        Browser.getWindow().getConsole().log(panel);
        panel.setWidget(dashboardView.get().asWidget());
    }

    @Override
    public String mayStop() {
        return "Stop DashboardActivity?";
    }
    
    
    
}
