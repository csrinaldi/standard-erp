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

  public static <E extends Enum<E>> Converter<String, E> stringToEnum(final Class<E> enumType) {
        
    return new AbstractConverter<String, E>() {
      
      public E apply(String name) {
        return Enum.valueOf(enumType, name);
      }
      
      @Override
      protected String unapply(E output) {
        return output.name();
      }      
    };
  }
  
  public static <E extends Enum<E>> Converter<Integer, E> integerToEnum(final Class<E> enumType) {
        
    return new AbstractConverter<Integer, E>() {
      
      public E apply(Integer index) {
        return enumType.getEnumConstants()[index];
      }
      
      @Override
      protected Integer unapply(E output) {
        return output.ordinal();
      }      
    };
  }
  
  public static <F, T> Converter<F, T> assemble(final Function<F, T> function,
      final Function<T, F> inverse) {

    return new AbstractConverter<F, T>() {

      @Override
      public T apply(F input) {
        return function.apply(input);
      }
      
      @Override
      protected F unapply(T output) {
        return inverse.apply(output);
      }
    };
  }
}
