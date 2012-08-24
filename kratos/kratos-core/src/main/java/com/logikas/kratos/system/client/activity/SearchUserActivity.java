package com.logikas.kratos.system.client.activity;

import com.logikas.kratos.system.client.view.SearchUserView;
import com.logikas.kratos.system.shared.proxy.UserProxy;
import com.logikas.kratos.system.shared.request.SystemRequestFactory;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.Receiver;

import java.util.List;

import javax.inject.Inject;

public class SearchUserActivity extends AbstractActivity implements SearchUserView.Presenter  {
  
  private final SystemRequestFactory rf;
  
  private final SearchUserView view;
  
  @Inject
  SearchUserActivity(SystemRequestFactory rf, SearchUserView view) {
    this.rf = rf;
    this.view = view;
    view.setPresenter(this);
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    panel.setWidget(view);
  }
  
  @Override
  public void searchUsers(String name, final int start, int length) {
    rf.createUserService().findByName(name, start, length).fire(new Receiver<List<UserProxy>>() {
      @Override
      public void onSuccess(List<UserProxy> users) {
        view.setUsers(start, users);                
      }
    });
  }
  
  @Override
  public void findAll(final int start, int length) {
    rf.createUserService().findAll(start, length).fire(new Receiver<List<UserProxy>>() {
      @Override
      public void onSuccess(List<UserProxy> users) {
        view.setUsers(start, users);                
      }
    });    
  }
}
