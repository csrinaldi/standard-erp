package com.logikas.kratos.core.ui.client.adapters;

import com.logikas.kratos.common.base.Converter;

import com.google.gwt.editor.client.LeafValueEditor;

public class ConvertedValueEditor<T, F> implements LeafValueEditor<T> {
  
  private LeafValueEditor<F> peer;
  private Converter<F, T> converter;
  
  protected ConvertedValueEditor(LeafValueEditor<F> peer, Converter<F, T> converter){
    this.peer = peer;
    this.converter = converter;
  }
  
  
  public static <Left, Right> ConvertedValueEditor<Left, Right> of(LeafValueEditor<Right> peer, Converter<Right, Left> converter) {
    return new ConvertedValueEditor<Left, Right>(peer, converter);
  }
  
  @Override
  public T getValue() {
    return converter.apply(peer.getValue());
  }
  
  public void setValue(T value) {
    peer.setValue(converter.unapply(value));    
  }
}
