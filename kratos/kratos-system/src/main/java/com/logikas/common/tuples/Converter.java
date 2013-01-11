package com.logikas.common.tuples;

import com.google.common.base.Function;

public interface Converter<F, T> extends Function<F, T> {

  Converter<T, F> inverse();
}
