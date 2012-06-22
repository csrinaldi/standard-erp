package com.logikas.kratools.annextract.client;

import com.logikas.kratools.annextract.shared.Unwrapper;

import java.lang.annotation.Annotation;

public class DefaultValidationGroupFilter implements Unwrapper<Annotation>{
  
  @Override
  public Annotation filter(Annotation[] values) {
    return null;
  }
}
