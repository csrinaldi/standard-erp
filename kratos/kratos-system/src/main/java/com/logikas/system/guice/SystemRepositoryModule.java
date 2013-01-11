package com.logikas.system.guice;


import com.google.inject.AbstractModule;
import com.logikas.system.repository.SystemUserRepository;
import com.logikas.system.repository.impl.SystemUserRepositoryImpl;

import javax.inject.Singleton;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
class SystemRepositoryModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(SystemUserRepository.class).to(SystemUserRepositoryImpl.class).in(Singleton.class);
    //bindRepository(UserRepository.class);
  }
}
