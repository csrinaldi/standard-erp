package com.logikas.kratos.main.client.ioc;

import com.logikas.kratos.main.shared.place.DefaultPlace;
import com.logikas.kratos.system.client.mvp.SystemActivityMapper;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
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

public class MainClientModule2 extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    bind(ActivityMapper.class).to(SystemActivityMapper.class).in(Singleton.class);
  }

  /*****************************************************************/

  @Provides
  @Named("mainPanel")
  InsertPanel.ForIsWidget getMainPanel() {
    return RootPanel.get();
  }

  /*****************************************************************/
  @Provides
  @Singleton
  public PlaceHistoryHandler getHistoryHandler(PlaceController placeController,
      PlaceHistoryMapper historyMapper, EventBus eventBus) {

    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, new DefaultPlace());
    return historyHandler;
  }

  @Provides
  @Singleton
  public PlaceController getPlaceController(EventBus eventBus) {
    return new PlaceController(eventBus);
  }

  @Provides
  @Singleton
  public ActivityManager getCenterActivityManager(ActivityMapper activityMapper, EventBus eventBus) {
    return new ActivityManager(activityMapper, eventBus);
  }
}
