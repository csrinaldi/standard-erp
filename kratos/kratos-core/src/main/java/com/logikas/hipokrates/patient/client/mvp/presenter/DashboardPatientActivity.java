/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.hipokrates.patient.client.mvp.presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Provider;
import com.logikas.hipokrates.patient.client.view.DasboardPatientView;

/**
 *
 * @author cristian
 */
public class DashboardPatientActivity extends AbstractActivity{

    
    Provider<DasboardPatientView> dashboardPatientView;
    
    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        panel.setWidget(dashboardPatientView.get().asWidget());
                
    }

    
    
    

    
    
}
