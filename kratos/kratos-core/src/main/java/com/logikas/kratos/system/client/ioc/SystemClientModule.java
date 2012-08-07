package com.logikas.kratos.system.client.ioc;

import com.logikas.kratos.system.client.view.CreateUserView;
import com.logikas.kratos.system.client.widget.CreateUserWidget;
import com.logikas.kratos.system.shared.request.SystemRequestFactory;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;

import javax.inject.Singleton;

public class SystemClientModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(CreateUserView.class).to(CreateUserWidget.class).in(Singleton.class);
  }

  @Provides
  @Singleton
  SystemRequestFactory getRequestFactory() {
    return GWT.create(SystemRequestFactory.class);
  }
}
