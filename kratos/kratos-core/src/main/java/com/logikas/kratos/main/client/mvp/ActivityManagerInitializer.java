/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.main.client.mvp;

import com.google.gwt.activity.shared.ActivityManager;
import com.logikas.kratos.main.client.view.LayoutView;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author csrinaldi
 */
public class ActivityManagerInitializer {

    @Inject
    public ActivityManagerInitializer(
            LayoutView layout,
            @Named("center") ActivityManager centerActivityManager,
            @Named("west") ActivityManager westActivityManager
            ) {
        centerActivityManager.setDisplay(layout.getCenterRegion());
        westActivityManager.setDisplay(layout.getWestRegion());
       
    }
}