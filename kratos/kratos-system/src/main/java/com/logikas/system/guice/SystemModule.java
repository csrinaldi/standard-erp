package com.logikas.system.guice;

import com.google.inject.AbstractModule;

/**
 * 
 * @author Andrés Testi (atesti@logikas.com)
 * @since 04/01/2013
 */

public class SystemModule extends AbstractModule {
  
  @Override
  protected void configure() {
    install(new SystemRepositoryModule());
    install(new SystemServiceModule());
    install(new SystemI18nModule());
  }
}
