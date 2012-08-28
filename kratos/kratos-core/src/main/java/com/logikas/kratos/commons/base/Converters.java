package com.logikas.kratos.commons.base;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

public class Converters {

  public static <T> Converter<T, T> forDefault(final Supplier<T> defaultValue) {

    return new Converter<T, T>() {

      public T apply(T input) {
        return input;
      }

      public T unapply(T output) {
        return output == null ? defaultValue.get() : output;
      }
    };
  }

  public static <T> Converter<T, T> forDefault(T defaultValue) {
    return forDefault(Suppliers.ofInstance(defaultValue));
  }

  public static <F, T> Converter<F, T> compose(final Function<F, T> function,
      final Function<T, F> inverse) {

    return new Converter<F, T>() {

      public T apply(F input) {
        return function.apply(input);
      }

      public F unapply(T output) {
        return inverse.apply(output);
      }
    };
  }

  public static <F, T> Function<T, F> decompose(final Converter<F, T> converter) {
    return new Function<T, F>() {
      public F apply(T input) {
        return converter.unapply(input);
      }
    };
  }
}
