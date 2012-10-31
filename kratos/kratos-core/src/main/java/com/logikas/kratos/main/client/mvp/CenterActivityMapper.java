/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.main.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.logikas.kratos.main.client.mvp.presenter.DashboardActivity;
import com.logikas.kratos.main.shared.place.DashboardPlace;
import elemental.client.Browser;
import javax.inject.Inject;
import javax.inject.Provider;

/**
 *
 * @author csrinaldi
 */
public class CenterActivityMapper implements ActivityMapper {

    @Inject
    private Provider<DashboardActivity> dashboardActivity;

    @Override
    public Activity getActivity(Place place) {

        if (place instanceof DashboardPlace) {
            Browser.getWindow().getConsole().log(place);
            return dashboardActivity.get();
        }

        return null;
    }
}
