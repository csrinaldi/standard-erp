/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.modernui.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author Cristian Rinaldi
 */
public class MetroUiExample extends Composite {
    
    private static MetroUiExampleUiBinder uiBinder = GWT.create(MetroUiExampleUiBinder.class);
    
    interface MetroUiExampleUiBinder extends UiBinder<Widget, MetroUiExample> {
    }
    
    public MetroUiExample() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
