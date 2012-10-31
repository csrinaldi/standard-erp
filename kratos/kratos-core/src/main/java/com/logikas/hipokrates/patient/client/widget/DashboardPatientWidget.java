/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.hipokrates.patient.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.logikas.hipokrates.patient.client.view.DasboardPatientView;

/**
 *
 * @author cristian
 */
public class DashboardPatientWidget implements DasboardPatientView {
    
    private static DashboardPatientWidgetUiBinder uiBinder = GWT.create(DashboardPatientWidgetUiBinder.class);

    interface DashboardPatientWidgetUiBinder extends UiBinder<HTMLPanel, DashboardPatientWidget> {
    }
    
    private HTMLPanel root;
    
    public DashboardPatientWidget() {
        root = uiBinder.createAndBindUi(this);
    }
    
    @Override
    public Widget asWidget() {
        return root;
    }
}
