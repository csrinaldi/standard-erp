package com.logikas.kratos.system.shared.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SearchUserPlace extends Place {

  public static class Tokenizer implements PlaceTokenizer<SearchUserPlace> {

    @Override
    public SearchUserPlace getPlace(String token) {
      return new SearchUserPlace();
    }

    public String getToken(SearchUserPlace place) {
      return "";
    }
  }
}
