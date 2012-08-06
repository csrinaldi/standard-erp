package com.logikas.kratos.system.shared.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class CreateUserPlace extends Place {

  public static class Tokenizer implements PlaceTokenizer<CreateUserPlace> {
    
    @Override
    public CreateUserPlace getPlace(String token) {
      return new CreateUserPlace();
    }

    public String getToken(CreateUserPlace place) {
      return "";
    }
  }
}
