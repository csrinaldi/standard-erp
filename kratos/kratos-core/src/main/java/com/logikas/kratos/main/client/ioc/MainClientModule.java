package com.logikas.kratos.main.client.ioc;

import com.logikas.kratos.system.client.mvp.SystemActivityMapper;
import com.logikas.kratos.system.client.mvp.SystemPlaceHistoryMapper;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;


public class MainClientModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    bind(ActivityMapper.class).to(SystemActivityMapper.class).in(Singleton.class);
    //bind(PlaceHistoryMapper.class).to(SystemPlaceHistoryMapper.class).in(Singleton.class);
  }
  
  @Provides
  @Singleton
  PlaceHistoryMapper getHistoryMapper() {
    return GWT.create(SystemPlaceHistoryMapper.class);
  }

  @Provides
  @Named("mainPanel")
  InsertPanel.ForIsWidget getMainPanel() {
    return RootPanel.get();
  }

  @Provides
  @Singleton
  PlaceController getPlaceController(EventBus eventBus) {
    return new PlaceController(eventBus);
  }
  
  @Provides
  @Singleton
  ActivityManager getActivityManager(ActivityMapper mapper, EventBus eventBus) {
    return new ActivityManager(mapper, eventBus);
  }
  
  @Provides
  @Singleton
  public PlaceHistoryHandler getPlaceHistoryHandler(PlaceHistoryMapper mapper) {
    return new PlaceHistoryHandler(mapper);
  }
}
