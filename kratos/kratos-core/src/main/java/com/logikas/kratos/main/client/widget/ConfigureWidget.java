/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.main.client.widget;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.logikas.kratos.main.client.view.ConfigureView;

/**
 *
 * @author cristian
 */
public class ConfigureWidget implements ConfigureView{

    private static ConfigureWidget.ConfigureWidgetUiBinder uiBinder = GWT.create(ConfigureWidget.ConfigureWidgetUiBinder.class);

    interface ConfigureWidgetUiBinder extends UiBinder<LayoutPanel, ConfigureWidget> {
    }
    
    LayoutPanel root;

    public ConfigureWidget() {
        root = uiBinder.createAndBindUi(this);
    }
    
    @Override
    public Widget asWidget() {
        return root;
    }
    
}
