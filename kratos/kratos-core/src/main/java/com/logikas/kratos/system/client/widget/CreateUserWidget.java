package com.logikas.kratos.system.client.widget;

import com.logikas.kratos.system.client.view.CreateUserView;
import com.logikas.kratos.system.shared.proxy.UserProxy;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public class CreateUserWidget extends Composite implements CreateUserView, Editor<UserProxy> {

  static interface SearchUserBinder extends UiBinder<VerticalPanel, CreateUserWidget> {}
  
  static interface Driver extends RequestFactoryEditorDriver<UserProxy, CreateUserWidget> {}
  
  private static final SearchUserBinder BINDER = GWT.create(SearchUserBinder.class);
  
  private Presenter presenter;

  public CreateUserWidget() {
    initWidget(BINDER.createAndBindUi(this));
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;    
  } 
  
  @UiField
  ValueBoxEditorDecorator<String> name;
  
  @UiHandler("save")
  void save(ClickEvent event) {
    presenter.save();
  }

  @Override
  public RequestFactoryEditorDriver<UserProxy, ? extends Editor<UserProxy>> createEditor(RequestFactory rf) {
    final RequestFactoryEditorDriver<UserProxy, CreateUserWidget> driver = GWT.create(Driver.class);
    driver.initialize(rf, this);
    return driver;
  } 
}
