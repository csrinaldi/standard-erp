package com.logikas.kratos.core.ioc;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.hibernate.validator.method.MethodValidator;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@SuppressWarnings({"deprecation", "unused"})
public class ValidationInterceptor implements MethodInterceptor {

  private final ValidatorFactory factory;

  @Inject
  ValidationInterceptor(ValidatorFactory factory) {
    this.factory = factory;
  }

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    
    final MethodValidator validator = factory.getValidator().unwrap(MethodValidator.class);

    final Set<MethodConstraintViolation<Object>> paramViolatons =
        validator.validateAllParameters(invocation.getThis(), invocation.getMethod(), invocation
            .getArguments());

    if (!paramViolatons.isEmpty()) {
      throw new MethodConstraintViolationException(paramViolatons);
    }

    Object result = invocation.proceed();

    Set<MethodConstraintViolation<Object>> returnViolations =
        validator.validateReturnValue(invocation.getThis(), invocation.getMethod(), result);

    if (!returnViolations.isEmpty()) {
      throw new MethodConstraintViolationException(returnViolations);
    }

    return result;
  }
}
