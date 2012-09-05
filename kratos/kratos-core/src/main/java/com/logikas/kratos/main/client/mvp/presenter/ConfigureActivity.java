/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.kratos.main.client.mvp.presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.logikas.kratos.main.client.view.ConfigureView;
import javax.inject.Inject;
import javax.inject.Provider;

/**
 * 
 * @author Cristian Rinaldi  cristian.rinaldi@logikas.com
 * @version
 * @date 03/09/2012
 * Logikas - Conectacto Ideas 
 */
public class ConfigureActivity extends AbstractActivity{

    @Inject
    private Provider<ConfigureView> configureView;
    
    
    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        panel.setWidget(configureView.get());
    }

}
