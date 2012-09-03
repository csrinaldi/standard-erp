package com.logikas.kratos.core.ioc.validation;

import com.google.inject.Injector;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;

class IocConstraintValidatorFactory implements ConstraintValidatorFactory {

  private final Injector injector;

  @Inject
  IocConstraintValidatorFactory(Injector injector) {
    this.injector = injector;
  }

  @Override
  public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
    return injector.getInstance(key);
  }
}
