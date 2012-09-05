/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.system.client.mvp;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.web.bindery.event.shared.EventBus;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author cristian
 */
@Singleton
public class SystemActivityManager extends ActivityManager{

    @Inject
    public SystemActivityManager(SystemActivityMapper mapper, EventBus eventBus) {
        super(mapper, eventBus);
    }
    
}
