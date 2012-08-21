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
import com.logikas.kratos.main.client.Bootstrap;
import com.logikas.kratos.main.client.BootstrapImpl;
import com.logikas.kratos.main.client.mvp.CenterActivityMapper;
import com.logikas.kratos.main.client.mvp.WestActivityMapper;
import com.logikas.kratos.main.client.view.LayoutView;
import com.logikas.kratos.main.client.widget.LayoutWidget;
import com.logikas.kratos.main.shared.place.CorePlaceHistoryMapper;
import com.logikas.kratos.main.shared.place.DefaultPlace;


public class MainClientModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    bind(Bootstrap.class).to(BootstrapImpl.class);

    //bind(ActivityMapper.class).to(SystemActivityMapper.class).in(Singleton.class);
    bind(PlaceHistoryMapper.class).to(CorePlaceHistoryMapper.class).in(Singleton.class);
    
    bind(LayoutView.class).to(LayoutWidget.class).in(Singleton.class);
    
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
    @Named("center")
    public ActivityManager getCenterActivityManager(LayoutView mainLayout,
            CenterActivityMapper activityMapper, EventBus eventBus) {
        ActivityManager manager = new ActivityManager(activityMapper, eventBus);
        return manager;
    }
    
    @Provides
    @Singleton
    @Named("west")
    public ActivityManager getWestActivityManager(LayoutView mainLayout,
            WestActivityMapper activityMapper, EventBus eventBus) {
        ActivityManager manager = new ActivityManager(activityMapper, eventBus);
        return manager;
    }
}
    
