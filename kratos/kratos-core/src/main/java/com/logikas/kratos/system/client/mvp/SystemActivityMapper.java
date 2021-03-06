package com.logikas.kratos.system.client.mvp;

import com.logikas.kratos.system.client.activity.CreateUserActivity;
import com.logikas.kratos.system.client.activity.SearchUserActivity;
import com.logikas.kratos.system.shared.place.CreateUserPlace;
import com.logikas.kratos.system.shared.place.SearchUserPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import elemental.client.Browser;

import javax.inject.Inject;
import javax.inject.Provider;

public class SystemActivityMapper implements ActivityMapper {

    @Inject
    private Provider<CreateUserActivity> createUser;
    @Inject
    private Provider<SearchUserActivity> searchUser;

    @Override
    public Activity getActivity(Place place) {

        if (place instanceof CreateUserPlace) {
            return createUser.get();
        }
        if (place instanceof SearchUserPlace) {
            return searchUser.get();
        }

        Browser.getWindow().getConsole().log("SystemActivityMapper NULL Return  ");
        
        return null;
    }
}
