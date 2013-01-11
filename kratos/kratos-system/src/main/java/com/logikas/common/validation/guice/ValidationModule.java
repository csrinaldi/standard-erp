package com.logikas.common.validation.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.matcher.Matchers;

import javax.inject.Singleton;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class ValidationModule extends AbstractModule {

  @Override
  protected void configure() {

    final ValidationInterceptor interceptor =
        new ValidationInterceptor(getProvider(ValidatorFactory.class));

    final ValidationMatcher matcher = new ValidationMatcher();

    bindInterceptor(Matchers.any(), matcher, interceptor);
  }

  @Provides
  @Singleton
  ValidatorFactory getValidatorFactory(IocConstraintValidatorFactory cvFactory) {
    return Validation.byDefaultProvider().configure().constraintValidatorFactory(cvFactory)
        .buildValidatorFactory();
  }
}
