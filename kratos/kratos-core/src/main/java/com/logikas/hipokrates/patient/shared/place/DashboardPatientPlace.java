/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logikas.hipokrates.patient.shared.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

/**
 *
 * @author cristian
 */
public class DashboardPatientPlace extends Place {

    @Prefix(value="Patient")
    public static class Tokenizer implements PlaceTokenizer<DashboardPatientPlace> {

        @Override
        public DashboardPatientPlace getPlace(String token) {
            return new DashboardPatientPlace();
        }

        @Override
        public String getToken(DashboardPatientPlace place) {
            return "";
        }
    }
    
}
