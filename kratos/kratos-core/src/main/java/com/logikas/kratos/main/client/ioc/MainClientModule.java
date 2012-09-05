package com.logikas.kratos.main.client.ioc;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.logikas.kratos.main.client.manager.ViewManager;
import com.logikas.kratos.main.client.manager.ViewManagerImpl;
import com.logikas.kratos.main.client.mvp.CenterActivityMapper;
import com.logikas.kratos.main.client.view.ConfigureView;
import com.logikas.kratos.main.client.view.LayoutView;
import com.logikas.kratos.main.client.widget.ConfigureWidget;
import com.logikas.kratos.main.client.widget.LayoutWidget;
import com.logikas.kratos.main.shared.place.MainPlaceHistoryMapper;
import com.logikas.kratos.main.shared.place.DefaultPlace;

public class MainClientModule extends AbstractGinModule {

    @Override
    protected void configure() {

        bind(PlaceHistoryMapper.class).to(MainPlaceHistoryMapper.class).in(Singleton.class);

        bind(LayoutView.class).to(LayoutWidget.class).in(Singleton.class);
        
        bind(ViewManager.class).to(ViewManagerImpl.class).in(Singleton.class);
        
        bind(ConfigureView.class).to(ConfigureWidget.class).in(Singleton.class);
    }

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
    @Named("center")
    public ActivityManager getCenterActivityManager(CenterActivityMapper activityMapper, EventBus eventBus) {
        ActivityManager manager = new ActivityManager(activityMapper, eventBus);
        return manager;
    }

    /*@Provides
    @Singleton
    @Named("west")
    public ActivityManager getWestActivityManager(LayoutView mainLayout,
            WestActivityMapper activityMapper, EventBus eventBus) {
        ActivityManager manager = new ActivityManager(activityMapper, eventBus);
        return manager;
    }*/
}
