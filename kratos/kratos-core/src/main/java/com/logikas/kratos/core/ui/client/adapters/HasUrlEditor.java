package com.logikas.kratos.core.ui.client.adapters;

import com.logikas.kratos.core.ui.client.HasUrl;

import com.google.gwt.editor.client.LeafValueEditor;

public class HasUrlEditor implements LeafValueEditor<String> {

  private final HasUrl peer;

  public static HasUrlEditor of(HasUrl peer) {
    return new HasUrlEditor(peer);
  }

  protected HasUrlEditor(HasUrl peer) {
    this.peer = peer;
  }

  @Override
  public void setValue(String value) {
    peer.setUrl(value);
  }

  @Override
  public String getValue() {
    return peer.getUrl();
  }
}
