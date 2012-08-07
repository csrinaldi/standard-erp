package com.logikas.kratos.main.client.ioc;

import com.google.gwt.core.client.GWT;

public class MainInjectorImpl implements com.logikas.kratos.main.client.ioc.MainInjector {
  public com.logikas.kratos.main.client.Bootstrap getBootstrap() {
    return get_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$();
  }
  
  
  /**
   * Binding for com.google.gwt.place.shared.PlaceController declared at:
   *   com.google.gwt.place.shared.PlaceController com.logikas.kratos.main.client.ioc.MainClientModule.getPlaceController(com.google.web.bindery.event.shared.EventBus)
   */
  private native com.google.gwt.place.shared.PlaceController com$logikas$kratos$main$client$ioc$MainClientModule_getPlaceController_methodInjection(com.logikas.kratos.main.client.ioc.MainClientModule injectee, com.google.web.bindery.event.shared.EventBus _0) /*-{
    return injectee.@com.logikas.kratos.main.client.ioc.MainClientModule::getPlaceController(Lcom/google/web/bindery/event/shared/EventBus;)(_0);
  }-*/;
  
  private com.google.gwt.place.shared.PlaceController create_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$() {
    return com$logikas$kratos$main$client$ioc$MainClientModule_getPlaceController_methodInjection(new com.logikas.kratos.main.client.ioc.MainClientModule(), get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$());
  }
  
  private com.google.gwt.place.shared.PlaceController singleton_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.google.gwt.place.shared.PlaceController com.logikas.kratos.main.client.ioc.MainClientModule.getPlaceController(com.google.web.bindery.event.shared.EventBus)
   */
  private com.google.gwt.place.shared.PlaceController get_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$() {
    if (singleton_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$ = create_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.google.web.bindery.event.shared.SimpleEventBus declared at:
   *   Implicit binding for Key[type=com.google.web.bindery.event.shared.SimpleEventBus, annotation=[none]]
   */
  private void memberInject_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$(com.google.web.bindery.event.shared.SimpleEventBus injectee) {
    
  }
  
  private com.google.web.bindery.event.shared.SimpleEventBus create_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$() {
    Object created = GWT.create(com.google.web.bindery.event.shared.SimpleEventBus.class);
    assert created instanceof com.google.web.bindery.event.shared.SimpleEventBus;
    com.google.web.bindery.event.shared.SimpleEventBus result = (com.google.web.bindery.event.shared.SimpleEventBus) created;
    
    memberInject_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.google.web.bindery.event.shared.SimpleEventBus declared at:
   *   Implicit binding for Key[type=com.google.web.bindery.event.shared.SimpleEventBus, annotation=[none]]
   */
  private com.google.web.bindery.event.shared.SimpleEventBus get_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$() {
    return create_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.gwt.user.client.ui.InsertPanel$ForIsWidget declared at:
   *   com.google.gwt.user.client.ui.InsertPanel$ForIsWidget com.logikas.kratos.main.client.ioc.MainClientModule.getMainPanel()
   */
  private native com.google.gwt.user.client.ui.InsertPanel.ForIsWidget com$logikas$kratos$main$client$ioc$MainClientModule_getMainPanel_methodInjection(com.logikas.kratos.main.client.ioc.MainClientModule injectee) /*-{
    return injectee.@com.logikas.kratos.main.client.ioc.MainClientModule::getMainPanel()();
  }-*/;
  
  private com.google.gwt.user.client.ui.InsertPanel.ForIsWidget create_Key$type$com$google$gwt$user$client$ui$InsertPanel$ForIsWidget$_annotation$$com$google$inject$name$Named$value$mainPanel$$() {
    return com$logikas$kratos$main$client$ioc$MainClientModule_getMainPanel_methodInjection(new com.logikas.kratos.main.client.ioc.MainClientModule());
  }
  
  
  /**
   * Binding for com.google.gwt.user.client.ui.InsertPanel$ForIsWidget declared at:
   *   com.google.gwt.user.client.ui.InsertPanel$ForIsWidget com.logikas.kratos.main.client.ioc.MainClientModule.getMainPanel()
   */
  private com.google.gwt.user.client.ui.InsertPanel.ForIsWidget get_Key$type$com$google$gwt$user$client$ui$InsertPanel$ForIsWidget$_annotation$$com$google$inject$name$Named$value$mainPanel$$() {
    return create_Key$type$com$google$gwt$user$client$ui$InsertPanel$ForIsWidget$_annotation$$com$google$inject$name$Named$value$mainPanel$$();
  }
  
  
  
  /**
   * Binding for com.logikas.kratos.system.client.mvp.SystemActivityMapper declared at:
   *   Implicit binding for Key[type=com.logikas.kratos.system.client.mvp.SystemActivityMapper, annotation=[none]]
   */
  private void memberInject_Key$type$com$logikas$kratos$system$client$mvp$SystemActivityMapper$_annotation$$none$$(com.logikas.kratos.system.client.mvp.SystemActivityMapper injectee) {
    
  }
  
  private native com.logikas.kratos.system.client.mvp.SystemActivityMapper com$logikas$kratos$system$client$mvp$SystemActivityMapper_SystemActivityMapper_methodInjection(com.google.inject.Provider _0) /*-{
    return @com.logikas.kratos.system.client.mvp.SystemActivityMapper::new(Lcom/google/inject/Provider;)(_0);
  }-*/;
  
  private com.logikas.kratos.system.client.mvp.SystemActivityMapper create_Key$type$com$logikas$kratos$system$client$mvp$SystemActivityMapper$_annotation$$none$$() {
    com.logikas.kratos.system.client.mvp.SystemActivityMapper result = com$logikas$kratos$system$client$mvp$SystemActivityMapper_SystemActivityMapper_methodInjection(get_Key$type$com$google$inject$Provider$com$logikas$kratos$system$client$activity$CreateUserActivity$$_annotation$$none$$());
    memberInject_Key$type$com$logikas$kratos$system$client$mvp$SystemActivityMapper$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.logikas.kratos.system.client.mvp.SystemActivityMapper declared at:
   *   Implicit binding for Key[type=com.logikas.kratos.system.client.mvp.SystemActivityMapper, annotation=[none]]
   */
  private com.logikas.kratos.system.client.mvp.SystemActivityMapper get_Key$type$com$logikas$kratos$system$client$mvp$SystemActivityMapper$_annotation$$none$$() {
    return create_Key$type$com$logikas$kratos$system$client$mvp$SystemActivityMapper$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.gwt.place.shared.PlaceHistoryMapper declared at:
   *   com.google.gwt.place.shared.PlaceHistoryMapper com.logikas.kratos.main.client.ioc.MainClientModule.getHistoryMapper()
   */
  private native com.google.gwt.place.shared.PlaceHistoryMapper com$logikas$kratos$main$client$ioc$MainClientModule_getHistoryMapper_methodInjection(com.logikas.kratos.main.client.ioc.MainClientModule injectee) /*-{
    return injectee.@com.logikas.kratos.main.client.ioc.MainClientModule::getHistoryMapper()();
  }-*/;
  
  private com.google.gwt.place.shared.PlaceHistoryMapper create_Key$type$com$google$gwt$place$shared$PlaceHistoryMapper$_annotation$$none$$() {
    return com$logikas$kratos$main$client$ioc$MainClientModule_getHistoryMapper_methodInjection(new com.logikas.kratos.main.client.ioc.MainClientModule());
  }
  
  private com.google.gwt.place.shared.PlaceHistoryMapper singleton_Key$type$com$google$gwt$place$shared$PlaceHistoryMapper$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.google.gwt.place.shared.PlaceHistoryMapper com.logikas.kratos.main.client.ioc.MainClientModule.getHistoryMapper()
   */
  private com.google.gwt.place.shared.PlaceHistoryMapper get_Key$type$com$google$gwt$place$shared$PlaceHistoryMapper$_annotation$$none$$() {
    if (singleton_Key$type$com$google$gwt$place$shared$PlaceHistoryMapper$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$gwt$place$shared$PlaceHistoryMapper$_annotation$$none$$ = create_Key$type$com$google$gwt$place$shared$PlaceHistoryMapper$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$gwt$place$shared$PlaceHistoryMapper$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.logikas.kratos.system.client.view.CreateUserView declared at:
   *   com.logikas.kratos.system.client.ioc.SystemClientModule.configure(SystemClientModule.java:16)
   */
  private com.logikas.kratos.system.client.view.CreateUserView create_Key$type$com$logikas$kratos$system$client$view$CreateUserView$_annotation$$none$$() {
    return get_Key$type$com$logikas$kratos$system$client$widget$CreateUserWidget$_annotation$$none$$();
  }
  
  private com.logikas.kratos.system.client.view.CreateUserView singleton_Key$type$com$logikas$kratos$system$client$view$CreateUserView$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.logikas.kratos.system.client.ioc.SystemClientModule.configure(SystemClientModule.java:16)
   */
  private com.logikas.kratos.system.client.view.CreateUserView get_Key$type$com$logikas$kratos$system$client$view$CreateUserView$_annotation$$none$$() {
    if (singleton_Key$type$com$logikas$kratos$system$client$view$CreateUserView$_annotation$$none$$ == null) {
      singleton_Key$type$com$logikas$kratos$system$client$view$CreateUserView$_annotation$$none$$ = create_Key$type$com$logikas$kratos$system$client$view$CreateUserView$_annotation$$none$$();
    }
    return singleton_Key$type$com$logikas$kratos$system$client$view$CreateUserView$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.logikas.kratos.system.shared.request.SystemRequestFactory declared at:
   *   com.logikas.kratos.system.shared.request.SystemRequestFactory com.logikas.kratos.system.client.ioc.SystemClientModule.getRequestFactory()
   */
  private native com.logikas.kratos.system.shared.request.SystemRequestFactory com$logikas$kratos$system$client$ioc$SystemClientModule_getRequestFactory_methodInjection(com.logikas.kratos.system.client.ioc.SystemClientModule injectee) /*-{
    return injectee.@com.logikas.kratos.system.client.ioc.SystemClientModule::getRequestFactory()();
  }-*/;
  
  private com.logikas.kratos.system.shared.request.SystemRequestFactory create_Key$type$com$logikas$kratos$system$shared$request$SystemRequestFactory$_annotation$$none$$() {
    return com$logikas$kratos$system$client$ioc$SystemClientModule_getRequestFactory_methodInjection(new com.logikas.kratos.system.client.ioc.SystemClientModule());
  }
  
  private com.logikas.kratos.system.shared.request.SystemRequestFactory singleton_Key$type$com$logikas$kratos$system$shared$request$SystemRequestFactory$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.logikas.kratos.system.shared.request.SystemRequestFactory com.logikas.kratos.system.client.ioc.SystemClientModule.getRequestFactory()
   */
  private com.logikas.kratos.system.shared.request.SystemRequestFactory get_Key$type$com$logikas$kratos$system$shared$request$SystemRequestFactory$_annotation$$none$$() {
    if (singleton_Key$type$com$logikas$kratos$system$shared$request$SystemRequestFactory$_annotation$$none$$ == null) {
      singleton_Key$type$com$logikas$kratos$system$shared$request$SystemRequestFactory$_annotation$$none$$ = create_Key$type$com$logikas$kratos$system$shared$request$SystemRequestFactory$_annotation$$none$$();
    }
    return singleton_Key$type$com$logikas$kratos$system$shared$request$SystemRequestFactory$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.google.gwt.place.shared.PlaceHistoryHandler declared at:
   *   public com.google.gwt.place.shared.PlaceHistoryHandler com.logikas.kratos.main.client.ioc.MainClientModule.getPlaceHistoryHandler(com.google.gwt.place.shared.PlaceHistoryMapper)
   */
  private com.google.gwt.place.shared.PlaceHistoryHandler com$logikas$kratos$main$client$ioc$MainClientModule_getPlaceHistoryHandler_methodInjection(com.logikas.kratos.main.client.ioc.MainClientModule injectee, com.google.gwt.place.shared.PlaceHistoryMapper _0) {
    return injectee.getPlaceHistoryHandler(_0);
  }
  
  private com.google.gwt.place.shared.PlaceHistoryHandler create_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$() {
    return com$logikas$kratos$main$client$ioc$MainClientModule_getPlaceHistoryHandler_methodInjection(new com.logikas.kratos.main.client.ioc.MainClientModule(), get_Key$type$com$google$gwt$place$shared$PlaceHistoryMapper$_annotation$$none$$());
  }
  
  private com.google.gwt.place.shared.PlaceHistoryHandler singleton_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   public com.google.gwt.place.shared.PlaceHistoryHandler com.logikas.kratos.main.client.ioc.MainClientModule.getPlaceHistoryHandler(com.google.gwt.place.shared.PlaceHistoryMapper)
   */
  private com.google.gwt.place.shared.PlaceHistoryHandler get_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$() {
    if (singleton_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$ = create_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.google.gwt.activity.shared.ActivityManager declared at:
   *   com.google.gwt.activity.shared.ActivityManager com.logikas.kratos.main.client.ioc.MainClientModule.getActivityManager(com.google.gwt.activity.shared.ActivityMapper,com.google.web.bindery.event.shared.EventBus)
   */
  private native com.google.gwt.activity.shared.ActivityManager com$logikas$kratos$main$client$ioc$MainClientModule_getActivityManager_methodInjection(com.logikas.kratos.main.client.ioc.MainClientModule injectee, com.google.gwt.activity.shared.ActivityMapper _0, com.google.web.bindery.event.shared.EventBus _1) /*-{
    return injectee.@com.logikas.kratos.main.client.ioc.MainClientModule::getActivityManager(Lcom/google/gwt/activity/shared/ActivityMapper;Lcom/google/web/bindery/event/shared/EventBus;)(_0, _1);
  }-*/;
  
  private com.google.gwt.activity.shared.ActivityManager create_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$() {
    return com$logikas$kratos$main$client$ioc$MainClientModule_getActivityManager_methodInjection(new com.logikas.kratos.main.client.ioc.MainClientModule(), get_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$(), get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$());
  }
  
  private com.google.gwt.activity.shared.ActivityManager singleton_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.google.gwt.activity.shared.ActivityManager com.logikas.kratos.main.client.ioc.MainClientModule.getActivityManager(com.google.gwt.activity.shared.ActivityMapper,com.google.web.bindery.event.shared.EventBus)
   */
  private com.google.gwt.activity.shared.ActivityManager get_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$() {
    if (singleton_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$ = create_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.google.web.bindery.event.shared.EventBus declared at:
   *   com.logikas.kratos.main.client.ioc.MainClientModule.configure(MainClientModule.java:26)
   */
  private com.google.web.bindery.event.shared.EventBus create_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$() {
    return get_Key$type$com$google$web$bindery$event$shared$SimpleEventBus$_annotation$$none$$();
  }
  
  private com.google.web.bindery.event.shared.EventBus singleton_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.logikas.kratos.main.client.ioc.MainClientModule.configure(MainClientModule.java:26)
   */
  private com.google.web.bindery.event.shared.EventBus get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$() {
    if (singleton_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$ = create_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.google.gwt.activity.shared.ActivityMapper declared at:
   *   com.logikas.kratos.main.client.ioc.MainClientModule.configure(MainClientModule.java:27)
   */
  private com.google.gwt.activity.shared.ActivityMapper create_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$() {
    return get_Key$type$com$logikas$kratos$system$client$mvp$SystemActivityMapper$_annotation$$none$$();
  }
  
  private com.google.gwt.activity.shared.ActivityMapper singleton_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   com.logikas.kratos.main.client.ioc.MainClientModule.configure(MainClientModule.java:27)
   */
  private com.google.gwt.activity.shared.ActivityMapper get_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$() {
    if (singleton_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$ == null) {
      singleton_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$ = create_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$();
    }
    return singleton_Key$type$com$google$gwt$activity$shared$ActivityMapper$_annotation$$none$$;
  }
  
  
  /**
   * Binding for com.logikas.kratos.system.client.widget.CreateUserWidget declared at:
   *   Implicit binding for Key[type=com.logikas.kratos.system.client.widget.CreateUserWidget, annotation=[none]]
   */
  private void memberInject_Key$type$com$logikas$kratos$system$client$widget$CreateUserWidget$_annotation$$none$$(com.logikas.kratos.system.client.widget.CreateUserWidget injectee) {
    
  }
  
  private com.logikas.kratos.system.client.widget.CreateUserWidget create_Key$type$com$logikas$kratos$system$client$widget$CreateUserWidget$_annotation$$none$$() {
    Object created = GWT.create(com.logikas.kratos.system.client.widget.CreateUserWidget.class);
    assert created instanceof com.logikas.kratos.system.client.widget.CreateUserWidget;
    com.logikas.kratos.system.client.widget.CreateUserWidget result = (com.logikas.kratos.system.client.widget.CreateUserWidget) created;
    
    memberInject_Key$type$com$logikas$kratos$system$client$widget$CreateUserWidget$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.logikas.kratos.system.client.widget.CreateUserWidget declared at:
   *   Implicit binding for Key[type=com.logikas.kratos.system.client.widget.CreateUserWidget, annotation=[none]]
   */
  private com.logikas.kratos.system.client.widget.CreateUserWidget get_Key$type$com$logikas$kratos$system$client$widget$CreateUserWidget$_annotation$$none$$() {
    return create_Key$type$com$logikas$kratos$system$client$widget$CreateUserWidget$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.logikas.kratos.system.client.activity.CreateUserActivity declared at:
   *   Implicit binding for Key[type=com.logikas.kratos.system.client.activity.CreateUserActivity, annotation=[none]]
   */
  private void memberInject_Key$type$com$logikas$kratos$system$client$activity$CreateUserActivity$_annotation$$none$$(com.logikas.kratos.system.client.activity.CreateUserActivity injectee) {
    
  }
  
  private native com.logikas.kratos.system.client.activity.CreateUserActivity com$logikas$kratos$system$client$activity$CreateUserActivity_CreateUserActivity_methodInjection(com.logikas.kratos.system.shared.request.SystemRequestFactory _0, com.logikas.kratos.system.client.view.CreateUserView _1) /*-{
    return @com.logikas.kratos.system.client.activity.CreateUserActivity::new(Lcom/logikas/kratos/system/shared/request/SystemRequestFactory;Lcom/logikas/kratos/system/client/view/CreateUserView;)(_0, _1);
  }-*/;
  
  private com.logikas.kratos.system.client.activity.CreateUserActivity create_Key$type$com$logikas$kratos$system$client$activity$CreateUserActivity$_annotation$$none$$() {
    com.logikas.kratos.system.client.activity.CreateUserActivity result = com$logikas$kratos$system$client$activity$CreateUserActivity_CreateUserActivity_methodInjection(get_Key$type$com$logikas$kratos$system$shared$request$SystemRequestFactory$_annotation$$none$$(), get_Key$type$com$logikas$kratos$system$client$view$CreateUserView$_annotation$$none$$());
    memberInject_Key$type$com$logikas$kratos$system$client$activity$CreateUserActivity$_annotation$$none$$(result);
    return result;
  }
  
  
  /**
   * Binding for com.logikas.kratos.system.client.activity.CreateUserActivity declared at:
   *   Implicit binding for Key[type=com.logikas.kratos.system.client.activity.CreateUserActivity, annotation=[none]]
   */
  private com.logikas.kratos.system.client.activity.CreateUserActivity get_Key$type$com$logikas$kratos$system$client$activity$CreateUserActivity$_annotation$$none$$() {
    return create_Key$type$com$logikas$kratos$system$client$activity$CreateUserActivity$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.google.inject.Provider<com.logikas.kratos.system.client.activity.CreateUserActivity> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.logikas.kratos.system.client.activity.CreateUserActivity>, annotation=[none]]
   */
  private com.google.inject.Provider<com.logikas.kratos.system.client.activity.CreateUserActivity> create_Key$type$com$google$inject$Provider$com$logikas$kratos$system$client$activity$CreateUserActivity$$_annotation$$none$$() {
    return new com.google.inject.Provider<com.logikas.kratos.system.client.activity.CreateUserActivity>() { 
      public com.logikas.kratos.system.client.activity.CreateUserActivity get() { 
        return get_Key$type$com$logikas$kratos$system$client$activity$CreateUserActivity$_annotation$$none$$();
      }
    };
  }
  
  
  /**
   * Binding for com.google.inject.Provider<com.logikas.kratos.system.client.activity.CreateUserActivity> declared at:
   *   Implicit binding for Key[type=com.google.inject.Provider<com.logikas.kratos.system.client.activity.CreateUserActivity>, annotation=[none]]
   */
  private com.google.inject.Provider<com.logikas.kratos.system.client.activity.CreateUserActivity> get_Key$type$com$google$inject$Provider$com$logikas$kratos$system$client$activity$CreateUserActivity$$_annotation$$none$$() {
    return create_Key$type$com$google$inject$Provider$com$logikas$kratos$system$client$activity$CreateUserActivity$$_annotation$$none$$();
  }
  
  
  
  /**
   * Binding for com.logikas.kratos.main.client.Bootstrap declared at:
   *   Implicit binding for Key[type=com.logikas.kratos.main.client.Bootstrap, annotation=[none]]
   */
  private void memberInject_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$(com.logikas.kratos.main.client.Bootstrap injectee) {
    
  }
  
  private native com.logikas.kratos.main.client.Bootstrap com$logikas$kratos$main$client$Bootstrap_Bootstrap_methodInjection(com.google.gwt.user.client.ui.InsertPanel.ForIsWidget _0, com.google.web.bindery.event.shared.EventBus _1, com.google.gwt.place.shared.PlaceHistoryHandler _2, com.google.gwt.place.shared.PlaceController _3, com.google.gwt.activity.shared.ActivityManager _4) /*-{
    return @com.logikas.kratos.main.client.Bootstrap::new(Lcom/google/gwt/user/client/ui/InsertPanel$ForIsWidget;Lcom/google/web/bindery/event/shared/EventBus;Lcom/google/gwt/place/shared/PlaceHistoryHandler;Lcom/google/gwt/place/shared/PlaceController;Lcom/google/gwt/activity/shared/ActivityManager;)(_0, _1, _2, _3, _4);
  }-*/;
  
  private com.logikas.kratos.main.client.Bootstrap create_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$() {
    com.logikas.kratos.main.client.Bootstrap result = com$logikas$kratos$main$client$Bootstrap_Bootstrap_methodInjection(get_Key$type$com$google$gwt$user$client$ui$InsertPanel$ForIsWidget$_annotation$$com$google$inject$name$Named$value$mainPanel$$(), get_Key$type$com$google$web$bindery$event$shared$EventBus$_annotation$$none$$(), get_Key$type$com$google$gwt$place$shared$PlaceHistoryHandler$_annotation$$none$$(), get_Key$type$com$google$gwt$place$shared$PlaceController$_annotation$$none$$(), get_Key$type$com$google$gwt$activity$shared$ActivityManager$_annotation$$none$$());
    memberInject_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$(result);
    return result;
  }
  
  private com.logikas.kratos.main.client.Bootstrap singleton_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$ = null;
  
  
  /**
   * Singleton bound at:
   *   Implicit binding for Key[type=com.logikas.kratos.main.client.Bootstrap, annotation=[none]]
   */
  private com.logikas.kratos.main.client.Bootstrap get_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$() {
    if (singleton_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$ == null) {
      singleton_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$ = create_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$();
    }
    return singleton_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$;
  }
  
  public MainInjectorImpl() {
    
  }
  
}
