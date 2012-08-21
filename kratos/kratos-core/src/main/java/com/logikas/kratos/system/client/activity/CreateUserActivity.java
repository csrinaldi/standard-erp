package com.logikas.kratos.system.client.activity;

import com.logikas.kratos.system.client.view.CreateUserView;
import com.logikas.kratos.system.shared.place.SearchUserPlace;
import com.logikas.kratos.system.shared.proxy.UserProxy;
import com.logikas.kratos.system.shared.request.SystemRequestFactory;
import com.logikas.kratos.system.shared.request.UserServiceRequest;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.RequestContext;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;

public class CreateUserActivity extends AbstractActivity implements CreateUserView.Presenter {
  
  private final SystemRequestFactory rf;
  
  private final CreateUserView view;
  
  private final RequestFactoryEditorDriver<UserProxy, ? extends Editor<UserProxy>> driver;
    
  private final PlaceController placeController;
  
  @Inject
  CreateUserActivity(SystemRequestFactory rf, CreateUserView view, PlaceController placeController) {
    this.rf = rf;
    this.view = view;
    this.driver = view.createEditor(rf);
    this.placeController = placeController;
  }
  
  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {

    final UserServiceRequest request = rf.createUserService();
    view.setPresenter(this);
    panel.setWidget(view);
    final UserProxy user = request.create(UserProxy.class);
    driver.edit(user, request);
    request.save(user);
  }
  
  @Override
  public void save() {
    final RequestContext request = driver.flush();
    request.fire(new Receiver<Void>() {
      
      @Override
      public void onSuccess(Void response) {
        placeController.goTo(new SearchUserPlace());
      }
      
      @Override
      public void onConstraintViolation(Set<ConstraintViolation<?>> violations) {
        driver.setConstraintViolations(violations);
      }
    });    
  }
}
