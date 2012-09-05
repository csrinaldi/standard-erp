/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.kratos.main.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.logikas.kratos.main.client.mvp.presenter.ConfigureActivity;
import com.logikas.kratos.main.shared.place.ConfigurePlace;
import javax.inject.Inject;
import javax.inject.Provider;

/**
 *
 * @author csrinaldi
 */
public class CenterActivityMapper implements ActivityMapper {

    @Inject
    private Provider<ConfigureActivity> configureActivity;
    
    @Override
    public Activity getActivity(Place place) {

        if (place instanceof ConfigurePlace) {
            
            Window.alert("CenterActivityMapper");
            
            return configureActivity.get();
        }

        return null;
    }
}
