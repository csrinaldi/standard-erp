/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.kratos.main.shared.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 *
 * @author cristian
 */
public class DashboardPlace extends Place {

    public DashboardPlace() {
    }

    @Prefix("Dashboard")
    public static class Tokenizer implements PlaceTokenizer<DashboardPlace> {

        @Override
        public DashboardPlace getPlace(String token) {
            return new DashboardPlace();
        }

        @Override
        public String getToken(DashboardPlace place) {
            return "";
        }
    }
    
}
