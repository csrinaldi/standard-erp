package com.logikas.kratos.commons.base;

import com.google.common.base.Function;

public interface Converter<F, T> extends Function<F, T> {

  F unapply(T output);
}
