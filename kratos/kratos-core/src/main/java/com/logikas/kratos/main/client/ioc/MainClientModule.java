package com.logikas.kratos.main.client.ioc;

import com.logikas.kratos.system.client.mvp.SystemActivityMapper;
import com.logikas.kratos.system.client.mvp.SystemPlaceHistoryMapper;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Provides;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import javax.inject.Named;
import javax.inject.Singleton;

public class MainClientModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    bind(ActivityMapper.class).to(SystemActivityMapper.class).in(Singleton.class);
    bind(PlaceHistoryMapper.class).to(SystemPlaceHistoryMapper.class).in(Singleton.class);
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
}
