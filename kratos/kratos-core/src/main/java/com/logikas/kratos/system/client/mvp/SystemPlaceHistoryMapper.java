package com.logikas.kratos.system.client.mvp;

import com.logikas.kratos.system.shared.place.CreateUserPlace;
import com.logikas.kratos.system.shared.place.SearchUserPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({CreateUserPlace.Tokenizer.class, SearchUserPlace.Tokenizer.class})
public interface SystemPlaceHistoryMapper extends PlaceHistoryMapper {
}
