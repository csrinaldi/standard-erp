/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.main.client.widget;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.logikas.kratos.main.client.view.DashboardView;

/**
 *
 * @author cristian
 */
public class DashboardWidget implements DashboardView{

    private static DashboardWidget.ConfigureWidgetUiBinder uiBinder = GWT.create(DashboardWidget.ConfigureWidgetUiBinder.class);

    interface ConfigureWidgetUiBinder extends UiBinder<VerticalPanel, DashboardWidget> {
    }
    
    VerticalPanel root;

    public DashboardWidget() {
        root = uiBinder.createAndBindUi(this);
    }
    
    @Override
    public Widget asWidget() {
        return root;
    }
    
}
