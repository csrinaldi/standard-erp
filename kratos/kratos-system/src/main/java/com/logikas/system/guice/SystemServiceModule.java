package com.logikas.system.guice;


import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.logikas.system.service.SystemUserService;
import com.logikas.system.service.impl.SystemUserServiceImpl;

/**
 * 
 * @author Andrés Testi (atesti@logikas.com)
 * @since 04/01/2013
 */
class SystemServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(SystemUserService.class).to(SystemUserServiceImpl.class).in(Singleton.class);
  }
}
