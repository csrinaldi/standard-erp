package com.logikas.kratos.system.client.ioc;

import com.logikas.kratos.system.client.view.CreateUserView;
import com.logikas.kratos.system.client.view.SearchUserView;
import com.logikas.kratos.system.client.widget.CreateUserWidget;
import com.logikas.kratos.system.client.widget.SearchUserWidget;
import com.logikas.kratos.system.shared.request.SystemRequestFactory;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.web.bindery.event.shared.EventBus;
import com.logikas.kratos.system.client.mvp.SystemPlaceHistoryMapper;

import javax.inject.Singleton;

public class SystemClientModule extends AbstractGinModule {

  @Override
  protected void configure() {
    bind(CreateUserView.class).to(CreateUserWidget.class).in(Singleton.class);
    bind(SearchUserView.class).to(SearchUserWidget.class).in(Singleton.class);
  }
  
  @Provides
  @Singleton
  @Named("System")
  PlaceHistoryHandler getHistoryHandler(SystemPlaceHistoryMapper mapper){
      return new PlaceHistoryHandler(mapper);
      
  }

  // TODO utilizar el request factory global definido en main
  @Provides
  @Singleton
  SystemRequestFactory getRequestFactory(EventBus eventBus) {
    final SystemRequestFactory rf = GWT.create(SystemRequestFactory.class);
    rf.initialize(eventBus);
    return rf;
  }
}
