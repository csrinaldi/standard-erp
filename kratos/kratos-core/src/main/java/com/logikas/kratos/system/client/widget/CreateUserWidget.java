package com.logikas.kratos.system.client.widget;

import com.logikas.kratos.system.client.view.CreateUserView;
import com.logikas.kratos.system.shared.proxy.UserProxy;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.ui.client.ValueBoxEditorDecorator;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.RequestFactory;

public class CreateUserWidget extends Composite implements CreateUserView, Editor<UserProxy> {

  static interface SearchUserBinder extends UiBinder<VerticalPanel, CreateUserWidget> {
  }

  static interface Driver extends RequestFactoryEditorDriver<UserProxy, CreateUserWidget> {
  }

  private static final SearchUserBinder BINDER = GWT.create(SearchUserBinder.class);

  private Presenter presenter;

  public CreateUserWidget() {
    initWidget(BINDER.createAndBindUi(this));
    formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
    formPanel.setAction("/resources");
    formPanel.setMethod(FormPanel.METHOD_POST);
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  @UiField
  ValueBoxEditorDecorator<String> name;

  @UiField
  @Ignore
  Image avatarView;

  @UiField
  FormPanel formPanel;

  @UiField
  FileUpload avatarUploader;

  /*
   * @Path("avatar") LeafValueEditor<String> avatarView() {
   * 
   * }
   */

  @UiHandler("save")
  void onSave(ClickEvent event) {
    presenter.save();
  }

  @UiHandler("upload")
  void onUpload(ClickEvent event) {
    avatarUploader.setEnabled(false);
    formPanel.submit();
  }

  @UiHandler("upload")
  void onSubmitComplete(SubmitCompleteEvent event) {
    avatarUploader.setEnabled(true);
    final String result = event.getResults();
    if (result != null) {

      boolean jsonError = true;

      final JSONValue jsonResult = JSONParser.parseLenient(result);

      if (jsonResult != null) {

        final JSONObject object = jsonResult.isObject();

        if (object != null) {
          final JSONValue idValue = object.get("id");
          final JSONNumber id = idValue.isNumber();
          if (id != null) {
            avatarView.setUrl("/resources?id=" + id.doubleValue());
            jsonError = false;
          }
        }
      }
      if (jsonError) {
        Window.alert("JSON mal formado");
      }
    } else {
      Window.alert("Error al transferir archivo");
    }
  }

  @Override
  public RequestFactoryEditorDriver<UserProxy, ? extends Editor<UserProxy>> createEditor(
      RequestFactory rf) {
    final RequestFactoryEditorDriver<UserProxy, CreateUserWidget> driver = GWT.create(Driver.class);
    driver.initialize(rf, this);
    return driver;
  }
}
