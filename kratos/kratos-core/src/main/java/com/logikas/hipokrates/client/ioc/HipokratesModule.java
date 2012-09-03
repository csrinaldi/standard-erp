/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */
package com.logikas.hipokrates.client.ioc;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;

import com.logikas.kratos.core.plugin.client.jso.PluginRegistryImpl;
import com.logikas.kratos.core.plugin.shared.Distribution;
import com.logikas.kratos.core.plugin.shared.PluginRegistry;
import com.logikas.kratos.main.client.MainPlugin;
import com.logikas.kratos.main.client.ioc.MainClientModule;
import javax.inject.Singleton;

/**
 * 
 * @author cristian
 */
public class HipokratesModule extends AbstractGinModule {

  @Override
  protected void configure() {

    bind(PluginRegistry.class).to(PluginRegistryImpl.class).in(Singleton.class);
    install(new MainClientModule());
    // install(new SystemClientModule());

  }

  @Provides
  @Singleton
  Distribution getDistribution(PluginRegistry registry, MainPlugin main) {
    return new Distribution(registry, main);
  }
}
