package com.logikas.kratos.core.ui.client;

import com.logikas.kratos.core.ui.client.adapters.HasUrlEditor;

import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.user.client.ui.FileUpload;

public class ValueFileUpload extends FileUpload implements IsEditor<LeafValueEditor<String>>,
    HasUrl {

  private String url = null;

  @Override
  public String getUrl() {
    return url;
  }

  @Override
  public void setUrl(String url) {
    // Nada que hacer
  }

  @Override
  public LeafValueEditor<String> asEditor() {
    return HasUrlEditor.of(this);
  }
}
