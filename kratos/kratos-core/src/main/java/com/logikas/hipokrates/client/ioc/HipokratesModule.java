/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.hipokrates.client.ioc;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Provides;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.logikas.hipokrates.patient.client.PatientPlugin;
import com.logikas.hipokrates.patient.client.ioc.PatientClientModule;

import com.logikas.kratos.core.plugin.client.jso.PluginRegistryImpl;
import com.logikas.kratos.core.plugin.shared.Distribution;
import com.logikas.kratos.core.plugin.shared.PluginRegistry;
import com.logikas.kratos.core.plugin.shared.place.DispatchedHistoryMapper;
import com.logikas.kratos.core.ui.client.LayoutView;
import com.logikas.kratos.main.client.MainPlugin;
import com.logikas.kratos.main.client.ioc.MainClientModule;
import com.logikas.kratos.main.client.widget.LayoutWidget;
import com.logikas.kratos.main.shared.place.DefaultPlace;
import com.logikas.kratos.main.shared.place.MainPlaceHistoryMapper;
import com.logikas.kratos.system.client.SystemPlugin;
import com.logikas.kratos.system.client.ioc.SystemClientModule;
import javax.inject.Singleton;

/**
 *
 * @author cristian
 */
public class HipokratesModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(LayoutView.class).to(LayoutWidget.class).in(com.google.inject.Singleton.class);
        
        bind(EventBus.class).to(SimpleEventBus.class).in(com.google.inject.Singleton.class);

        bind(PluginRegistry.class).to(PluginRegistryImpl.class).in(Singleton.class);
        
        install(new MainClientModule());
        install(new SystemClientModule());
        install(new PatientClientModule());

    }
    
    @Provides
    @Singleton
    public PlaceHistoryHandler getHistoryHandler(PlaceController placeController,
            DispatchedHistoryMapper historyMapper, EventBus eventBus) {

        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, new DefaultPlace());
        return historyHandler;
    }

    @Provides
    @Singleton
    Distribution getDistribution(PluginRegistry registry, DispatchedHistoryMapper mapper, MainPlugin main, SystemPlugin system, PatientPlugin patient) {
        return new Distribution(registry, mapper, main, system, patient);
    }

    @Provides
    @Singleton
    public PlaceController getPlaceController(EventBus eventBus) {
        return new PlaceController(eventBus);
    }
}
