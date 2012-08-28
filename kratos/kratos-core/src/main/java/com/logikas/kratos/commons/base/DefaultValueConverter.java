package com.logikas.kratos.commons.base;

public class DefaultValueConverter<T> implements Converter<T, T> {
  
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
