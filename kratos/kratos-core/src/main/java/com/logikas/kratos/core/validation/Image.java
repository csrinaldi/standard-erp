package com.logikas.kratos.core.validation;

public @interface Image {

  int width();

  int height();

  Type[] types() default {};

  enum Type {
    JPG, PNG, GIF
  }
}
