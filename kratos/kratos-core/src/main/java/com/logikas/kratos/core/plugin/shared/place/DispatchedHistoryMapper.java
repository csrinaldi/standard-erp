package com.logikas.kratos.core.plugin.shared.place;

import java.util.HashSet;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import javax.inject.Singleton;

@Singleton
public class DispatchedHistoryMapper implements PlaceHistoryMapper {

    private final HashSet<PlaceHistoryMapper> mappers = new HashSet<PlaceHistoryMapper>();

    @Override
    public Place getPlace(String token) {
        for (PlaceHistoryMapper m : mappers) {
            Place p = m.getPlace(token);
            if (p != null) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String getToken(Place place) {
        for (PlaceHistoryMapper m : mappers) {
            String t = m.getToken(place);
            if (t != null) {
                return t;
            }
        }
        return null;
    }

    public void register(PlaceHistoryMapper mapper) {
        mappers.add(mapper);
    }
}
