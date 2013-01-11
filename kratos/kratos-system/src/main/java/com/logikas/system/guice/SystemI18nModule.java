package com.logikas.system.guice;

import com.logikas.common.i18n.guice.I18nModule;
import com.logikas.system.i18n.CreateUserMessages;

/**
 * 
 * @author Andrés Testi (atesti@logikas.com)
 * @since 04/01/2013
 */
public class SystemI18nModule extends I18nModule {
  
  @Override
  protected void configureResources() {
    bindBundle(CreateUserMessages.class);
  }
}
