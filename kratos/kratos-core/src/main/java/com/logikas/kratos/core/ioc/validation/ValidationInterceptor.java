package com.logikas.kratos.core.ioc.validation;

import com.logikas.kratos.core.validation.Validated;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.hibernate.validator.method.MethodValidator;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.Set;

import javax.inject.Provider;
import javax.validation.ValidatorFactory;

@SuppressWarnings({"deprecation"})
class ValidationInterceptor implements MethodInterceptor {

  private final Provider<ValidatorFactory> factory;

  ValidationInterceptor(Provider<ValidatorFactory> factory) {
    this.factory = factory;
  }

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {

    final MethodValidator validator = factory.get().getValidator().unwrap(MethodValidator.class);

    final Validated validated =
        AnnotationUtils.findAnnotation(invocation.getMethod(), Validated.class);

    final Class<?>[] groups = validated != null ? validated.value() : new Class<?>[] {};

    final Set<MethodConstraintViolation<Object>> paramViolatons =
        validator.validateAllParameters(invocation.getThis(), invocation.getMethod(), invocation
            .getArguments(), groups);

    if (!paramViolatons.isEmpty()) {
      throw new MethodConstraintViolationException(paramViolatons);
    }

    final Object result = invocation.proceed();

    final Set<MethodConstraintViolation<Object>> returnViolations =
        validator.validateReturnValue(invocation.getThis(), invocation.getMethod(), result, groups);

    if (!returnViolations.isEmpty()) {
      throw new MethodConstraintViolationException(returnViolations);
    }

    return result;
  }
}
