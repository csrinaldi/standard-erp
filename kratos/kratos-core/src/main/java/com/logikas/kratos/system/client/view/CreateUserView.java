package com.logikas.kratos.system.client.view;


import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.logikas.kratos.system.shared.proxy.UserProxy;

public interface CreateUserView extends IsWidget {

  interface Presenter {

    void save();
  }
  
  RequestFactoryEditorDriver<UserProxy, ? extends Editor<UserProxy>> createEditor(RequestFactory rf);

  void setPresenter(Presenter presenter);
}
