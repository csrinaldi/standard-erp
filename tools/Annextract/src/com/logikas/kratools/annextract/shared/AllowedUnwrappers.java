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
public @interface AllowedUnwrappers {

  public static class HeadUnwrapper implements Unwrapper<Annotation> {

    @Override
    public Annotation filter(Annotation[] annotations) {
      return annotations.length > 0 ? annotations[0] : null;
    }
  }

  Class<? extends Unwrapper<?>>[] value() default {HeadUnwrapper.class};
}
