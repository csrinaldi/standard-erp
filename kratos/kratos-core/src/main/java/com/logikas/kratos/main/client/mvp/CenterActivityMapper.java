/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.main.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;

/**
 *
 * @author csrinaldi
 */
public class CenterActivityMapper implements ActivityMapper{

    @Override
    public Activity getActivity(Place place) {
        
        GWT.log("getActivity "+place.toString());
        
        return null;
    }
    
}
