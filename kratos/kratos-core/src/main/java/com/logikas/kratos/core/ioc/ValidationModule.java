package com.logikas.kratos.core.ioc;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matchers;

import org.hibernate.validator.method.MethodValidator;
import org.hibernate.validator.method.metadata.MethodDescriptor;
import org.hibernate.validator.method.metadata.TypeDescriptor;

import java.lang.reflect.Method;

import javax.inject.Singleton;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@SuppressWarnings("deprecation")
public class ValidationModule extends AbstractModule {

  private static class MethodValidationMatcher extends AbstractMatcher<Method> {

    private final MethodValidator validator;

    public MethodValidationMatcher(MethodValidator validator) {
      this.validator = validator;
    }

    @Override
    public boolean matches(Method method) {

      final TypeDescriptor td = validator.getConstraintsForType(method.getDeclaringClass());

      final MethodDescriptor md =
          td.getConstraintsForMethod(method.getName(), method.getParameterTypes());

      return md.hasConstraints();
    }
  }

  @Override
  protected void configure() {

    final MethodValidator validator =
        getProvider(Validator.class).get().unwrap(MethodValidator.class);

    final MethodValidationMatcher validationMatcher = new MethodValidationMatcher(validator);

    final ValidationInterceptor interceptor = getProvider(ValidationInterceptor.class).get();

    bindInterceptor(Matchers.any(), validationMatcher, interceptor);
  }
  
  @Singleton
  ValidatorFactory getValidatorFactory() {
    return Validation.buildDefaultValidatorFactory();
  }
}
