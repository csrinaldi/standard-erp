/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.main.client.mvp;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.web.bindery.event.shared.EventBus;
import javax.inject.Inject;

/**
 *
 * @author cristian
 */
public class MainCenterActivityManager extends ActivityManager{
    
    @Inject
    public MainCenterActivityManager(CenterActivityMapper mapper, EventBus eventBus) {
        super(mapper, eventBus);
    }
}
