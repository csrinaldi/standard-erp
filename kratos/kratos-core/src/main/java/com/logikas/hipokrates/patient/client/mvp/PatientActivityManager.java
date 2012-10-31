/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.hipokrates.patient.client.mvp;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.web.bindery.event.shared.EventBus;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author cristian
 */
@Singleton
public class PatientActivityManager extends ActivityManager{

    @Inject
    public PatientActivityManager(PatientActivityMapper mapper, EventBus eventBus) {
        super(mapper, eventBus);
    }
    
}
