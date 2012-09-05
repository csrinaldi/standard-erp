package com.logikas.kratos.system.shared.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;


public class CreateUserPlace extends Place {

    @Prefix(value="User")
    public static class Tokenizer implements PlaceTokenizer<CreateUserPlace> {

        @Override
        public CreateUserPlace getPlace(String token) {
            return new CreateUserPlace();
        }

        @Override
        public String getToken(CreateUserPlace place) {
            return "";
        }
    }
}
