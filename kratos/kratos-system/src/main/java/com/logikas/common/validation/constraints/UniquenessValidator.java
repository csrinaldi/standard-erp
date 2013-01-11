/**
 * 
 */
package com.logikas.common.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Size;

/**
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public class UniquenessValidator implements ConstraintValidator<Uniqueness, Object> {

  @Override
  public void initialize(Uniqueness constraintAnnotation) {
  }

  @Size
  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    return false;
  }
}
