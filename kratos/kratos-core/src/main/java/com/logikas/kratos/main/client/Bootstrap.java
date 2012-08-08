package com.logikas.kratos.main.client;

import com.logikas.kratos.system.shared.place.CreateUserPlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class Bootstrap {

  private final InsertPanel.ForIsWidget mainPanel;

  private final EventBus eventBus;

  private final ActivityManager activityManager;

  private final PlaceHistoryHandler historyHandler;

  private final PlaceController placeController;

  @Inject
  Bootstrap(@Named("mainPanel") InsertPanel.ForIsWidget mainPanel, EventBus eventBus,
      PlaceHistoryHandler historyHandler, PlaceController placeController,
      ActivityManager activityManager) {
    this.mainPanel = mainPanel;
    this.eventBus = eventBus;
    this.activityManager = activityManager;
    this.historyHandler = historyHandler;
    this.placeController = placeController;
  }

  public void init() {

    final SimplePanel appWidget = new SimplePanel();

    activityManager.setDisplay(appWidget);

    historyHandler.register(placeController, eventBus, new CreateUserPlace());

    mainPanel.add(appWidget);

    historyHandler.handleCurrentHistory();
  }
}
