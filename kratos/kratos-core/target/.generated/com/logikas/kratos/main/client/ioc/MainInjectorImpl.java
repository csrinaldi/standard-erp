package com.logikas.kratos.main.client.ioc;

import com.google.gwt.core.client.GWT;

public class MainInjectorImpl implements com.logikas.kratos.main.client.ioc.MainInjector {
  public com.logikas.kratos.main.client.Bootstrap getBootstrap() {
    return get_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$();
  }
  
  
  /**
   * Binding for com.google.gwt.user.client.ui.InsertPanel$ForIsWidget declared at:
   *   com.google.gwt.user.client.ui.InsertPanel$ForIsWidget com.logikas.kratos.main.client.ioc.MainModule.getMainPanel()
   */
  private native com.google.gwt.user.client.ui.InsertPanel.ForIsWidget com$logikas$kratos$main$client$ioc$MainModule_getMainPanel_methodInjection(com.logikas.kratos.main.client.ioc.MainModule injectee) /*-{
    return injectee.@com.logikas.kratos.main.client.ioc.MainModule::getMainPanel()();
  }-*/;
  
  private com.google.gwt.user.client.ui.InsertPanel.ForIsWidget create_Key$type$com$google$gwt$user$client$ui$InsertPanel$ForIsWidget$_annotation$$com$google$inject$name$Named$value$mainPanel$$() {
    return com$logikas$kratos$main$client$ioc$MainModule_getMainPanel_methodInjection(new com.logikas.kratos.main.client.ioc.MainModule());
  }
  
  
  /**
   * Binding for com.google.gwt.user.client.ui.InsertPanel$ForIsWidget declared at:
   *   com.google.gwt.user.client.ui.InsertPanel$ForIsWidget com.logikas.kratos.main.client.ioc.MainModule.getMainPanel()
   */
  private com.google.gwt.user.client.ui.InsertPanel.ForIsWidget get_Key$type$com$google$gwt$user$client$ui$InsertPanel$ForIsWidget$_annotation$$com$google$inject$name$Named$value$mainPanel$$() {
    return create_Key$type$com$google$gwt$user$client$ui$InsertPanel$ForIsWidget$_annotation$$com$google$inject$name$Named$value$mainPanel$$();
  }
  
  
  
  /**
   * Binding for com.logikas.kratos.main.client.Bootstrap declared at:
   *   Implicit binding for Key[type=com.logikas.kratos.main.client.Bootstrap, annotation=[none]]
   */
  private void memberInject_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$(com.logikas.kratos.main.client.Bootstrap injectee) {
    
  }
  
  private native com.logikas.kratos.main.client.Bootstrap com$logikas$kratos$main$client$Bootstrap_Bootstrap_methodInjection(com.google.gwt.user.client.ui.InsertPanel.ForIsWidget _0) /*-{
    return @com.logikas.kratos.main.client.Bootstrap::new(Lcom/google/gwt/user/client/ui/InsertPanel$ForIsWidget;)(_0);
  }-*/;
  
  private com.logikas.kratos.main.client.Bootstrap create_Key$type$com$logikas$kratos$main$client$Bootstrap$_annotation$$none$$() {
    com.logikas.kratos.main.client.Bootstrap result = com$logikas$kratos$main$client$Bootstrap_Bootstrap_methodInjection(get_Key$type$com$google$gwt$user$client$ui$InsertPanel$ForIsWidget$_annotation$$com$google$inject$name$Named$value$mainPanel$$());
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
