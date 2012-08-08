package com.logikas.kratos.system.client.mvp;

import com.logikas.kratos.system.client.activity.CreateUserActivity;
import com.logikas.kratos.system.shared.place.CreateUserPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import javax.inject.Inject;
import javax.inject.Provider;

public class SystemActivityMapper implements ActivityMapper {
  
  private final Provider<CreateUserActivity> createUser;
  
  @Inject
  SystemActivityMapper(Provider<CreateUserActivity> createUser) {
    this.createUser = createUser;  
  }
  
  @Override
  public Activity getActivity(Place place) {
    if(place instanceof CreateUserPlace) {
      return createUser.get();      
    }
    return null;
  }
}
