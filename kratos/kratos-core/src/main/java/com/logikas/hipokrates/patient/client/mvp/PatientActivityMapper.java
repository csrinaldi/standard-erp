/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.hipokrates.patient.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Provider;
import com.logikas.hipokrates.patient.client.mvp.presenter.DashboardPatientActivity;
import com.logikas.hipokrates.patient.shared.place.DashboardPatientPlace;
import elemental.client.Browser;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author cristian
 */
@Singleton
public class PatientActivityMapper implements ActivityMapper {

    @Inject
    private Provider<DashboardPatientActivity> dashboardActivity;

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof DashboardPatientPlace) {
          return dashboardActivity.get();
        }
        
        Browser.getWindow().getConsole().log("PatientActivityMapper NULL Return");
        

        return null;
    }
}
