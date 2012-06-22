package com.logikas.kratools.annextract.shared;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface AllowedWrappers {

  @Retention(RetentionPolicy.RUNTIME)
  @Target({})
  public @interface Any {
  }

  Class<? extends Annotation>[] value() default {Any.class};
}
