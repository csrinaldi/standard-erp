package com.logikas.kratos.common.base;

public class DefaultValueConverter<T> extends AbstractConverter<T, T> {
  
  private final T defaultValue;
  
  DefaultValueConverter(T defaultValue) {
    this.defaultValue = defaultValue;
  }
  
  public T apply(T right) {
    return right == null? defaultValue: right;
  }
  
  public T unapply(T left) {
    return left;
  }
}
