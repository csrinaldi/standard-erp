package com.logikas.kratos.core.ui.client.adapters;

import com.google.gwt.editor.client.LeafValueEditor;

public class DefaultValueEditor<T> implements LeafValueEditor<T> {

  private final LeafValueEditor<T> peer;
  private final T defaultValue;

  protected DefaultValueEditor(LeafValueEditor<T> peer, T defaultValue) {
    this.peer = peer;
    this.defaultValue = defaultValue;
  }

  public static <T> DefaultValueEditor<T> of(LeafValueEditor<T> peer, T defaultValue) {
    return new DefaultValueEditor<T>(peer, defaultValue);
  }

  @Override
  public T getValue() {
    return peer.getValue();
  }

  public void setValue(T value) {
    peer.setValue(value == null ? defaultValue : value);
  }
}
