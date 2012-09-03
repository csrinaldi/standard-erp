package com.logikas.kratos.system.client.view;

import com.logikas.kratos.system.shared.proxy.UserProxy;

import com.google.gwt.user.client.ui.IsWidget;

import java.util.List;

public interface SearchUserView extends IsWidget {

  interface Presenter {

    void searchUsers(String name, int start, int length);

    void findAll(int start, int length);
  }

  void setPresenter(Presenter presenter);

  void setUsers(int start, List<UserProxy> users);
}
