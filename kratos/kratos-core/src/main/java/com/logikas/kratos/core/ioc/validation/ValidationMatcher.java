package com.logikas.kratos.core.ioc.validation;

import com.logikas.kratos.core.validation.Validated;

import com.google.inject.matcher.AbstractMatcher;

import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;

import javax.validation.Valid;

class ValidationMatcher extends AbstractMatcher<Method> {

  @Override
  public boolean matches(Method m) {
    return AnnotationUtils.findAnnotation(m, Validated.class) != null
        || AnnotationUtils.findAnnotation(m, Valid.class) != null;
  }
}
