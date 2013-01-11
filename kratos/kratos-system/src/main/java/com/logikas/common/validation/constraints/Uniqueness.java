/**
 * 
 */
package com.logikas.common.validation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UniquenessValidator.class)
public @interface Uniqueness {
  String message() default "{com.quiencotiza.common.validation.constraints.Uniqueness.message}";
  
  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
  
  String[] value();
  
  /**
   * Defines several <code>@Uniqueness</code> annotations on the same element
   * @see Uniqueness   * 
   */
  @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
  @Retention(RUNTIME)
  @Documented
  @interface List {
    Uniqueness[] value();
  }
}
