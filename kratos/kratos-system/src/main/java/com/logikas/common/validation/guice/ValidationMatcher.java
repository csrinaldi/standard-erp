package com.logikas.common.validation.guice;


import com.google.inject.matcher.AbstractMatcher;
import com.logikas.common.validation.Validated;

import java.lang.reflect.Method;

import javax.validation.Valid;

class ValidationMatcher extends AbstractMatcher<Method> {

  @Override
  public boolean matches(Method m) {
    return m.isAnnotationPresent(Validated.class) || m.isAnnotationPresent(Valid.class);
  }
}
