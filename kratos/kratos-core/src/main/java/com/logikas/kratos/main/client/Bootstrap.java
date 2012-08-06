package com.logikas.kratos.main.client;

import com.logikas.kratos.system.shared.place.CreateUserPlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.web.bindery.event.shared.EventBus;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class Bootstrap {

  private final InsertPanel.ForIsWidget mainPanel;

  private final EventBus eventBus;

  private final PlaceHistoryMapper historyMapper;

  private final ActivityMapper activityMapper;
  
  private final ActivityManager activityManager;

  private final PlaceHistoryHandler historyHandler;

  private final PlaceController placeController;

  @Inject
  Bootstrap(@Named("mainPanel") InsertPanel.ForIsWidget mainPanel, EventBus eventBus,
      PlaceHistoryMapper historyMapper, ActivityMapper activityMapper,
      PlaceHistoryHandler historyHandler, PlaceController placeController, ActivityManager activityManager) {
    this.mainPanel = mainPanel;
    this.eventBus = eventBus;
    this.historyMapper = historyMapper;
    this.activityMapper = activityMapper;
    this.activityManager = activityManager;
    this.historyHandler = historyHandler;
    this.placeController = placeController;
  }

  public void init() {    

    historyHandler.register(placeController, eventBus, new CreateUserPlace());  
    
    mainPanel.add(new Label("hello world"));
  }
}
