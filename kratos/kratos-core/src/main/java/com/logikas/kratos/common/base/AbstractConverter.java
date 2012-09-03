package com.logikas.kratos.common.base;

public abstract class AbstractConverter<F, T> implements Converter<F, T> {

  private final Converter<T, F> inverse = new Converter<T, F>() {

    public F apply(T input) {
      return unapply(input);
    }

    @Override
    public Converter<F, T> inverse() {
      return AbstractConverter.this;
    }
  };

  @Override
  public Converter<T, F> inverse() {
    return inverse;
  }

  protected abstract F unapply(T output);
}
