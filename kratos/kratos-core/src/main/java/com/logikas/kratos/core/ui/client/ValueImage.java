package com.logikas.kratos.core.ui.client;

import com.logikas.kratos.core.ui.client.adapters.HasUrlEditor;

import com.google.gwt.editor.client.IsEditor;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.user.client.ui.Image;


public class ValueImage extends Image implements HasUrl, IsEditor<LeafValueEditor<String>> {
  
  @Override
  public LeafValueEditor<String> asEditor() {
    return HasUrlEditor.of(this);
  }
}
