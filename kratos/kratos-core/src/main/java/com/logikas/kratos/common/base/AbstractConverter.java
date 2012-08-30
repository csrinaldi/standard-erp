package com.logikas.kratos.common.base;

import com.google.common.base.Function;

public abstract class AbstractConverter<F, T> implements Converter<F, T> {
  
  private final Function<T, F> inverse = new Function<T, F>() {
    
    public F apply(T input) {
      return unapply(input);      
    }   
  };
  
  @Override
  public Function<T, F> inverse() {
    return inverse;
  }

  protected abstract F unapply(T output);
}
