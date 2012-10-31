package com.logikas.kratos.main.client.ioc;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.web.bindery.event.shared.EventBus;
import com.logikas.kratos.main.client.manager.ViewManager;
import com.logikas.kratos.main.client.manager.ViewManagerImpl;
import com.logikas.kratos.main.client.mvp.CenterActivityMapper;
import com.logikas.kratos.main.client.view.DashboardView;
import com.logikas.kratos.main.client.widget.DashboardWidget;
import com.logikas.kratos.main.shared.place.MainPlaceHistoryMapper;

public class MainClientModule extends AbstractGinModule {

    @Override
    protected void configure() {
       
        bind(ViewManager.class).to(ViewManagerImpl.class).in(Singleton.class);
        
        //bind(ConfigureView.class).to(ConfigureWidget.class).in(Singleton.class);
        
        bind(DashboardView.class).to(DashboardWidget.class).in(Singleton.class);
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
