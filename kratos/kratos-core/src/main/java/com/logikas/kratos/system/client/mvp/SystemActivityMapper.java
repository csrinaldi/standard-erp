package com.logikas.kratos.system.client.mvp;

import com.logikas.kratos.system.client.activity.CreateUserActivity;
import com.logikas.kratos.system.shared.place.CreateUserPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;
import com.logikas.kratos.main.shared.place.DefaultPlace;

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
      
      GWT.log("System.getActivity");
      
      
    if(place instanceof CreateUserPlace) {
      return createUser.get();      
    }else if ( place instanceof DefaultPlace ) {
      return createUser.get();  
    }
    return null;
  }
}
