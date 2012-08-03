package com.logikas.kratos.main.client.ioc;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Provides;

import javax.inject.Named;

public class MainClientModule extends AbstractGinModule {

  @Override
  protected void configure() {
    
  }

  @Provides
  @Named("mainPanel")
  InsertPanel.ForIsWidget getMainPanel() {
    return RootPanel.get();
  }
}
