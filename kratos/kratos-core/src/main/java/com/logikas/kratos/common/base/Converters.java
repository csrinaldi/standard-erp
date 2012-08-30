package com.logikas.kratos.common.base;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;

public class Converters {

  @SuppressWarnings("rawtypes")
  private static final Converter IDENTITY = new AbstractConverter<Object, Object>() {

    @Override
    public Object apply(Object input) {
      return input;
    }

    @Override
    public Object unapply(Object output) {
      return output;
    }
  };

  @SuppressWarnings("unchecked")
  public static <T> Converter<T, T> identity() {
    return IDENTITY;
  }

  private static final Converter<Byte, Long> BYTE_TO_LONG = new AbstractConverter<Byte, Long>() {

    @Override
    public Long apply(Byte input) {
      return input.longValue();
    }

    @Override
    public Byte unapply(Long output) {
      return output.byteValue();
    }
  };

  public static Converter<Byte, Long> byteToLong() {
    return BYTE_TO_LONG;
  }

  private static final Converter<Short, Long> SHORT_TO_LONG = new AbstractConverter<Short, Long>() {

    @Override
    public Long apply(Short input) {
      return input.longValue();
    }

    @Override
    public Short unapply(Long output) {
      return output.shortValue();
    }
  };

  public static Converter<Short, Long> shortToLong() {
    return SHORT_TO_LONG;
  }

  public static <F, T> Converter<F, T> forBiMap(final BiMap<F, T> biMap) {

    return new AbstractConverter<F, T>() {

      public T apply(F input) {
        return biMap.get(input);
      }

      public F unapply(T output) {
        return biMap.inverse().get(output);
      }
    };
  }

  public static <T> Converter<T, T> forDefault(final Supplier<T> defaultValue) {

    return new AbstractConverter<T, T>() {

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

  public static <F, T> Converter<F, T> assemble(final Function<F, T> function,
      final Function<T, F> inverse) {

    return new Converter<F, T>() {

      public T apply(F input) {
        return function.apply(input);
      }

      @Override
      public Function<T, F> inverse() {
        return inverse;
      }
    };
  }

  public static <F, T> Converter<T, F> inverse(final Converter<F, T> converter) {

    return new AbstractConverter<T, F>() {

      public F apply(T input) {
        return converter.inverse().apply(input);
      }

      public T unapply(F output) {
        return converter.apply(output);
      }
    };
  }
}
