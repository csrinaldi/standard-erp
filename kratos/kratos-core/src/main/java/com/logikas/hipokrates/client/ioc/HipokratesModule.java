/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.hipokrates.client.ioc;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Provides;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import com.logikas.kratos.core.plugin.client.jso.PluginRegistryImpl;
import com.logikas.kratos.core.plugin.shared.Distribution;
import com.logikas.kratos.core.plugin.shared.PluginRegistry;
import com.logikas.kratos.main.client.MainPlugin;
import com.logikas.kratos.main.client.ioc.MainClientModule;
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
        bind(EventBus.class).to(SimpleEventBus.class).in(com.google.inject.Singleton.class);

        bind(PluginRegistry.class).to(PluginRegistryImpl.class).in(Singleton.class);
        install(new MainClientModule());
        install(new SystemClientModule());

    }

    @Provides
    @Singleton
    Distribution getDistribution(PluginRegistry registry, MainPlugin main, SystemPlugin system) {
        return new Distribution(registry, main, system);
    }

    @Provides
    @Singleton
    public PlaceController getPlaceController(EventBus eventBus) {
        return new PlaceController(eventBus);
    }
}
