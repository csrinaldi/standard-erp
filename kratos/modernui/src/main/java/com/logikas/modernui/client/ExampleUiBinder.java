/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logikas.modernui.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * ModernUI
 *
 * Documentation of Class ExampleUibinder
 *
 *
 * Package: com.logikas.modernui.client 
 * Last modification: 19/12/2012
 * File: ExampleUibinder.java
 * 
 * @author Cristian Rinaldi
 * cristian.rinaldi@logikas.com
 * Logikas - Conectando Ideas.
 * 
 */
public class ExampleUiBinder extends Composite {
    interface ExampleUiBinderUiBinder extends UiBinder<HTMLPanel, ExampleUiBinder> {
    }

    private static ExampleUiBinderUiBinder ourUiBinder = GWT.create(ExampleUiBinderUiBinder.class);

    public ExampleUiBinder() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}
