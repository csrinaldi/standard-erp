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
public class ConfigurePlace extends Place {

    public ConfigurePlace() {
    }

    
    public static class Tokenizer implements PlaceTokenizer<ConfigurePlace> {

        @Override
        public ConfigurePlace getPlace(String token) {
            return new ConfigurePlace();
        }

        @Override
        public String getToken(ConfigurePlace place) {
            return "";
        }
    }
}
